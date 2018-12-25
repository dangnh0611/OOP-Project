package oop.g8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import oop.g8.generator.entity.CountryGenerator;
import oop.g8.generator.entity.EventGenerator;
import oop.g8.generator.entity.LocationGenerator;
import oop.g8.generator.entity.OrganizationGenerator;
import oop.g8.generator.entity.PersonGenerator;
import oop.g8.generator.entity.SourceGenerator;
import oop.g8.generator.entity.TimeGenerator;
import oop.g8.repository.relation.RelaR;
import oop.g8.service.InitDB;
import oop.g8.service.QueryService;
import oop.g8.service.ScannerService;
import oop.g8.service.Wrap;

/**
 * public void run(String... args) throws Exception <----> hàm main() mọi thứ
 * trong hàm run(
 * 
 * @author Hoang Nam
 *
 */
@Component
public class OopProAppEntry implements CommandLineRunner {

	@Autowired
	private QueryService queryService;

	@Autowired
	private InitDB initDbService;

	@Autowired
	private ScannerService scn;

	// test
	@Autowired
	private Wrap w;

	@Autowired
	private RelaR rr;

	private int selection;

	@Override
	public void run(String... args) throws Exception {

		SourceGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData/entity/Source/domain_list");
		PersonGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Person\\firstname_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Person\\midname_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Person\\lastname_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Person\\job_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Person\\des_element_list");
		OrganizationGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\organization_name_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\headquarters_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\firstname_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\midname_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\lastname_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\email_domain_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\des_element1_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\des_element2_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Organization\\country_list");
		CountryGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Country\\country_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Country\\capital_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Country\\des_element1_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Country\\des_element2_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Country\\des_element3_list");
		LocationGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Location\\location_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Location\\country_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Location\\des_element_list");
		EventGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Event\\venue_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Event\\country_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Event\\festival_name_list",
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Event\\product_name_list");
		TimeGenerator.getData(
				"C:\\Users\\Hoang Nam\\Documents\\CODE-SOURCE\\STS3.9\\OopPro\\src\\main\\resources\\rawData\\entity\\Time\\special_day_list");

		//
		System.out.println("read files done!");

		while (true) {
			System.out.println("------------------------MENU-------------------------");
			System.out.println("1.Sinh dữ liệu giả lập:");
			System.out.println("2.Truy vấn");
			System.out.println("3.Thoát");
			System.out.print("->Lựa chọn: ");
			selection = scn.getInputNum(3);
			switch (selection) {
			case 1:
				initDbService.addData();
				break;
			case 2:
				while (queryService.execQuery())
					;
				break;
			case 3:
				System.out.println("Chương trình kết thúc");
				System.exit(0);
			}
		}
//		Person p1 = new Person();
//		p1.setName("test relation");
//		p1.setAge(20);
//		p1.setDescription("tessssssss");
//		
//		Person p2 = new Person();
//		p2.setName("test 22");
//		
//		Entity e1 = new Entity();
//		e1.setName("e1");
//		
//		Entity e2 = new Entity();
//		e2.setName("e1");
//
//		Rela r = new Rela("some type", "some link", new Date(), p1, p2);
//		rr.save(r);

	}

}
