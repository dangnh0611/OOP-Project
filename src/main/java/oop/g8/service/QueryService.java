package oop.g8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oop.g8.model.entity.Country;
import oop.g8.model.entity.Event;
import oop.g8.model.entity.Location;
import oop.g8.model.entity.Organization;
import oop.g8.model.entity.Person;
import oop.g8.model.relation.country.C2C;
import oop.g8.model.relation.event.E2C;
import oop.g8.model.relation.event.E2L;
import oop.g8.model.relation.event.E2T;
import oop.g8.model.relation.organization.O2O;
import oop.g8.model.relation.person.P2C;
import oop.g8.model.relation.person.P2E;
import oop.g8.model.relation.person.P2O;
import oop.g8.model.relation.person.P2P;
import oop.g8.model.relation.person.P2T;

@Service
public class QueryService {

	@Autowired
	private Wrap w;

	@Autowired
	private ScannerService scn;

	private Scanner scn1 = new Scanner(System.in);;

	private int selection;

	public boolean execQuery() {
		System.out.println("---TRUY VẤN---");
		System.out.println("    1.LOCATION thuộc đất nước nào?");
		System.out.println("    2.Lấy thông tin mô tả của 1 LOCATION?");
		System.out.println("    3.COUNTRY có thủ đô là gì?");
		System.out.println("    4.PERSON đến từ đâu?");
		System.out.println("    5.PERSON đang làm công việc gì?");
		System.out.println("    6.EVENT diễn ra ở đâu?");
		System.out.println("    7.EVENT diễn ra trong khoảng thời gian nào?");
		System.out.println("    8.Thông tin liên hệ của ORGANIZATION");
		System.out.println("    9.PERSON nào làm việc cho một ORGANIZATION?");
		System.out.println("    10.Đưa ra danh sách các LOCATION thuộc 1 COUNTRY?");
		System.out.println("    11.Những PERSON nào sinh ra vào TIME?");
		System.out.println("    12.Những ORGANIZATION nào hợp tác với ORGANIZATION?");
		System.out.println("    13.Những PERSON nào đã đến thăm COUNTRY?");
		System.out.println("    14.Những EVENT diễn ra tại một COUNTRY trong YEAR?");
		System.out.println("    15.Những PERSON nào có quan hệ với 1 PERSON?");
		System.out.println("    16.PERSON đã tham gia những EVENT nào trong năm YEAR?");
		System.out.println("    17.LOCATION nào diễn ra nhiều event nhất?");
		System.out.println("    18.LOCATION đã tổ chức những sự kiện gì trong năm YEAR?");
		System.out.println("    19.Có bao nhiều người tham dự EVENT?");
		System.out.println("    20.COUNTRY nào có RELATIONSHIP với COUNTRY?");
		System.out.println("    21.Quay lại");
		System.out.print("->Lựa chọn: ");
		selection = scn.getInputNum(21);
		switch (selection) {
		case 1: {
			// return:country(thuộc tính) của 1 location
			// param:location-tên của location đó
			String location;
			System.out.println("    #LOCATION thuộc đất nước nào?");
			System.out.print("    >_LOCATION: ");
			location = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Location> ll = w.lr.findByName(location);
			System.out.println("Has " + ll.size() + " Location with name is " + location + " !");
			for (Location l : ll) {
				System.out.println(l.getCountry());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}
		case 2: {
			// return:description(thuộc tính) của 1 location
			// param:location-tên của địa danh đó
			String location;
			System.out.println("    #Lấy thông tin mô tả của 1 LOCATION?");
			System.out.print("    >_LOCATION: ");
			location = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Location> ll = w.lr.findByName(location);
			System.out.println("Has " + ll.size() + " Location with name is " + location + " !");
			for (Location l : ll) {
				System.out.println(l.getDescription());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 3: {
			// return:capital(thuộc tính) của 1 country
			// param:country-tên của country đó
			String country;
			System.out.println("    #COUNTRY có thủ đô là gì?");
			System.out.print("    >_COUNTRY: ");
			country = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Country> mylist = w.cr.findByName(country);
			System.out.println("Has " + mylist.size() + " result!");
			for (Country i : mylist) {
				System.out.println(i.getCapital());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 4: {
			String person;
			System.out.println("    #PERSON đến từ đâu?");
			System.out.print("    >_PERSON: ");
			person = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<P2C> mylist = w.pcr.findByPerson_NameAndType(person, "đến_từ");
			System.out.println("Has " + mylist.size() + " result!");
			for (P2C i : mylist) {
				System.out.println(i.getPerson().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 5: {
			// return:job(thuộc tính) của 1 person
			// param:person-tên của person đó
			String person;
			System.out.println("    #PERSON đang làm công việc gì?");
			System.out.print("    >_PERSON: ");
			person = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Person> mylist = w.pr.findByName(person);
			System.out.println("Has " + mylist.size() + " Person with name is " + person + " !");
			for (Person i : mylist) {
				System.out.println(i.getJob());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 6: {
			// return:name của 1 thực thể,có thể là location,có thể là country,chỉ cần thỏa
			// mãn (event)-[:diễn_ra_ở]->(?)
			// param:event-tên của event đó
			String event;
			System.out.println("    #EVENT diễn ra ở đâu?");
			System.out.print("    >_EVENT: ");
			event = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<E2L> mylist = w.elr.findByEvent_NameAndType(event, "diễn_ra_ở");
			System.out.println("Has " + mylist.size() + " Event with name is " + event
					+ " and has relation name 'diễn_ra_ở' with Location !");
			for (E2L i : mylist) {
				System.out.println(i.getLocation().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 7: {
			// return:timestart và timeend(đều là thuộc tính) của 1 event
			// param:event-tên sự kiện đó
			String event;
			System.out.println("    #EVENT diễn ra trong khoảng thời gian nào?");
			System.out.print("    >_EVENT: ");
			event = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Event> mylist = w.er.findByName(event);
			System.out.println("Has " + mylist.size() + " Event with name is " + event + " !");
			for (Event i : mylist) {
				System.out.println(i.getTimeStart() + "  -->  " + i.getTimeEnd());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 8: {
			// return:email,phone(thuộc tính) của 1 organization
			String organization;
			System.out.println("    #Thông tin liên hệ của ORGANIZATION");
			System.out.print("    >_ORGANIZATION: ");
			organization = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Organization> mylist = w.or.findByName(organization);
			System.out.println("Has " + mylist.size() + " Organization with name is " + organization + " !");
			for (Organization i : mylist) {
				System.out.println(i.getEmail() + " +  " + i.getPhone());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 9: {
			// return:name của những người làm việc cho một organization
			// param:organization-tên của organization đó
			String organization;
			System.out.println("    #PERSON nào làm việc cho một ORGANIZATION?");
			System.out.print("    >_PERSON: ");
			organization = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<P2O> mylist = w.por.findByTypeLikeAndOrganization_Name("*", organization);
			System.out.println("Has " + mylist.size() + " result !");
			for (P2O i : mylist) {
				System.out.println(i.getPerson().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 10: {
			// return:danh sách các location có chung thuộc tính country được nhập vào
			// param:country-tên của country được nhập vào
			String country;
			System.out.println("    #Đưa ra danh sách các LOCATION thuộc 1 COUNTRY?");
			System.out.print("    >_COUNTRY: ");
			country = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<Location> mylist = w.lr.findByCountry(country);
			System.out.println("Has " + mylist.size() + " Location with country's name is " + country + " !");
			for (Location i : mylist) {
				System.out.println(i.getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 11: {
			// return:name của person [sinh_ra_vào] TIME
			// param:time-thời gian nhập vào
			String time;
			System.out.println("    #Những PERSON nào sinh ra vào TIME?");
			System.out.print("    >_TIME: ");
			time = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();

			List<P2T> mylist = w.ptr.findByTypeAndTime_NameContaining("sinh ra vào", time);
			System.out.println("Has " + mylist.size() + " result!");
			for (P2T i : mylist) {
				System.out.println(i.getPerson().getName());
			}
		}

		case 12: {
			// return:danh sách các organization [hợp_tác_với] ORGANIZATION
			// param:organization-tên tổ chức đó
			String organization;
			System.out.println("    #Những ORGANIZATION nào hợp tác với ORGANIZATION?");
			System.out.print("    >_ORGANIZATION: ");
			organization = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<O2O> mylist = w.oor.findByTypeAndOrganization2_Name("hợp tác", organization);
			System.out.println("Has " + mylist.size() + "result!");
			for (O2O i : mylist) {
				System.out.println(i.getOrganization().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 13: {
			// return:name của person [đến_thăm] (country)
			// param:country-tên của quốc gia đó
			String country;
			System.out.println("    #Những PERSON nào đã đến thăm COUNTRY?");
			System.out.print("    >_COUNTRY: ");
			country = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<P2C> mylist = w.pcr.findByTypeAndCountry_Name("tới thăm", country);
			System.out.println("Has " + mylist.size() + "result!");
			for (P2C i : mylist) {
				System.out.println(i.getPerson().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 14: {
			// return:những event [diễn_ra_tại] 1 country,vừa diễn ra trong 1 thực thể
			// time(name của thực thể time này endwith YEAR)
			// param:country-tên của quốc gia
			// param:year-số năm
			// Chú thích:do hàm sinh,thực thể time lúc nào cũng endWith 1 số năm
			String country;
			String year;
			System.out.println("    #Những EVENT diễn ra tại một COUNTRY trong YEAR?");
			System.out.print("    >_COUNTRY: ");
			country = scn.getInputStr();
			System.out.print("    >_YEAR: ");
			year = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<E2C> mylist = w.ecr.findByCountry_NameAndType(country, "diễn ra tại");
			List<E2T> mylist2 = w.etr.findByTypeAndTime_Name_EndingWith("diễn ra vào", year);
			List<Event> el1 = new ArrayList<>();
			List<Event> el2 = new ArrayList<>();
			for (E2C j : mylist) {
				el1.add(j.getEvent());
			}
			for (E2T k : mylist2) {
				el2.add(k.getEvent());
			}
			el1.retainAll(el2);
			System.out.println("Has " + el1.size() + "result!");
			for (Event i : el1) {
				System.out.println(i.getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 15: {
			// return:name của những person --(1 person khác có tên nhập vào)
			// param:tên của person đó
			String person;
			System.out.println("    #Những PERSON nào có quan hệ với 1 PERSON?");
			System.out.print("    >_PERSON: ");
			person = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<P2P> mylist = w.ppr.findByPerson2_NameAndTypeLike(person, "*");
			System.out.println("Has " + mylist.size() + "result!");
			for (P2P i : mylist) {
				System.out.println(i.getPerson().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 16: {
			// return:những person [tham_gia] 1 EVENT,mà EVENT đó [diễn_ra_vào] 1 thực thể
			// Time có name endWith YEAR
			// param:country-tên của quốc gia
			// param:year-số năm
			// Chú thích:do hàm sinh,thực thể time lúc nào cũng endWith 1 số năm
			String person;
			String year;
			System.out.println("    #PERSON đã tham gia những EVENT nào trong năm YEAR?");
			System.out.print("    >_PERSON: ");
			person = scn.getInputStr();
			System.out.print("    >_YEAR: ");
			year = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<P2E> mylist = w.per.findByPerson_NameAndType(person, "tham gia");
			List<E2T> mylist2 = w.etr.findByTypeAndTime_Name_EndingWith("diễn ra vào", year);
			List<Event> el1 = new ArrayList<>();
			List<Event> el2 = new ArrayList<>();
			for (P2E j : mylist) {
				el1.add(j.getEvent());
			}
			for (E2T k : mylist2) {
				el2.add(k.getEvent());
			}
			el1.retainAll(el2);
			System.out.println("Has " + el1.size() + "result!");
			for (Event i : el1) {
				System.out.println(i.getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

//		case 17: {
//			// return:name của location diễn ra nhiều event nhất
//			// param:null
//			System.out.println("    #LOCATION nào diễn ra nhiều event nhất?");
//			System.out.print("    >_YEAR: ");
//			System.out.println("    #Kết quả:"); long s = System.currentTimeMillis();
//
//			
//			 System.out.println("Time excute query: " + (e - s ) + "ms"); break;
//		}

		case 18: {
			// return:name của các sự kiện [diễn ra vào] 1 thực thể Time có name endWith
			// YEAR,vừa được toorr chức bởi LOCATION
			// param:location-tên location
			// param:year-năm
			String location;
			String year;
			System.out.println("    #LOCATION đã tổ chức những sự kiện gì trong năm YEAR?");
			System.out.print("    >_LOCATION: ");
			location = scn.getInputStr();
			System.out.print("    >_YEAR: ");
			year = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<E2L> mylist = w.elr.findByTypeAndLocation_Name("được tổ chức bởi", location);
			List<E2T> mylist2 = w.etr.findByTypeAndTime_Name_EndingWith("diễn ra vào", year);

			List<Event> el1 = new ArrayList<>();
			List<Event> el2 = new ArrayList<>();
			for (E2L j : mylist) {
				el1.add(j.getEvent());
			}
			for (E2T k : mylist2) {
				el2.add(k.getEvent());
			}
			el1.retainAll(el2);
			System.out.println("Has " + el1.size() + "result!");
			for (Event i : el1) {
				System.out.println(i.getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}
//
		case 19: {
			// return:số người tham dự event
			// param:event-tên event
			String event;
			System.out.println("    #Có bao nhiều người tham dự EVENT?");
			System.out.print("    >_EVENT: ");
			event = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<P2E> mylist = w.per.findByEvent_NameAndType(event, "tham gia");
			System.out.println("Has " + mylist.size() + " person 'tham gia' sự kiện " + event);
//			for(P2E i : mylist) {
//				System.out.println(i.getPerson().getName());
//			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 20: {
			// return:(country nào?)-[:relationship]->(COUNTRY)
			// param:relationship:tên quan hệ
			// param: country tên đất nước
			String relationship;
			String country;
			System.out.println("    #COUNTRY nào có RELATIONSHIP với COUNTRY?");
			System.out.print("    >_RELATIONSHIP: ");
			relationship = scn.getInputStr();
			System.out.print("    >_COUNTRY: ");
			country = scn.getInputStr();
			System.out.println("    #Kết quả:");
			long s = System.currentTimeMillis();
			List<C2C> mylist = w.ccr.findByTypeAndCountry2_Name(relationship, country);
			System.out.println("Has " + mylist.size() + "result!");
			for (C2C i : mylist) {
				System.out.println(i.getCountry().getName());
			}

			long e = System.currentTimeMillis();
			System.out.println("Time excute query: " + (e - s) + "ms");
			break;
		}

		case 21: {
			return false;
		}

		}
		scn1.nextLine();
		return true;
	}
}
