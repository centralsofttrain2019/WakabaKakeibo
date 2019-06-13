package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Period;
import java.util.List;

import dao.Dao;
import dao.DepositDao;
import dto.DepositDto;

public class DepositService {

	public List<DepositDto> getDepositandSimulation(int userID){

		List<DepositDto> list = null;

		try ( Connection con= Dao.getConnection() ){

			DepositDao depositDao = new DepositDao(con);
			//UserDao userDao = new UserDao(con);

			list = depositDao.getDepositList(userID);
			//ここにリストのソート処理を記述

//			//リストの中身確認用
//			System.out.println("最初のデータ→"+ list.get(0).getBalance() + "\n" + "最新のデータ→" + list.get(list.size()-1).getBalance());


			this.addToDepositSimulation(list, 500000, userID);
			//後で目標金額をDBから取り出すように変更


//			//リストの中身確認用
//			System.out.println("最初のデータ→"+ list.get(0).getBalance() + "\n" + "最新のデータ→" + list.get(list.size()-1).getBalance());
//
//			//月数確認用
//			Period p = Period.between(list.get(0).getDate(), list.get(list.size()-1).getDate());
//			System.out.println(p.getYears() + "年" + p.getMonths() + "ヶ月");
//
//			System.out.println(list.get(list.size()-1).getDate().toString());
//			System.out.println(list.get(list.size()-1).getBalance());


		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return list;

	}

	private void addToDepositSimulation(List<DepositDto> inlist, int targetAmount, int userID){

		int month;
		double targetMonth;
		double slope;

		Period p = Period.between(inlist.get(0).getDate(), inlist.get(inlist.size()-1).getDate());

		month = p.getYears() * 12 + p.getMonths();

		//傾きの計算 a = ( y2 - y1 ) / ( x2 - x1 )
		slope = (inlist.get(inlist.size()-1).getBalance() - inlist.get(0).getBalance()) / month ;
		//目標達成の予測(月)の計算 x = (y - b ) / a　yは目標金額 bは開始時の貯金額(1万円)
		targetMonth = ( targetAmount - inlist.get(0).getBalance() ) / slope;

		//目標金額から算出した予測データをリストに挿入
		DepositDto dto = new DepositDto();

		dto.setDate(inlist.get(inlist.size()-1).getDate().plusMonths((long) Math.ceil(targetMonth)));
		//targetMonthは切り上げ long型でキャスト
		dto.setBalance(targetAmount);
		dto.setUserID(userID);

		inlist.add(dto);
	}

}