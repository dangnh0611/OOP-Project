package oop.g8.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oop.g8.generator.entity.CountryGenerator;
import oop.g8.generator.entity.EventGenerator;
import oop.g8.generator.entity.LocationGenerator;
import oop.g8.generator.entity.OrganizationGenerator;
import oop.g8.generator.entity.PersonGenerator;
import oop.g8.generator.entity.SourceGenerator;
import oop.g8.generator.entity.TimeGenerator;
import oop.g8.generator.relation.event.E2LG;
import oop.g8.generator.relation.event.E2OG;
import oop.g8.generator.relation.location.L2EG;
import oop.g8.generator.relation.organization.O2EG;
import oop.g8.generator.relation.person.P2CG;
import oop.g8.generator.relation.person.P2OG;
import oop.g8.generator.relation.person.P2PG;
import oop.g8.model.entity.Country;
import oop.g8.model.entity.Event;
import oop.g8.model.entity.Location;
import oop.g8.model.entity.Organization;
import oop.g8.model.entity.Person;
import oop.g8.model.entity.Time;
import oop.g8.model.relation.event.E2L;
import oop.g8.model.relation.event.E2O;
import oop.g8.model.relation.location.L2E;
import oop.g8.model.relation.organization.O2E;
import oop.g8.model.relation.person.P2C;
import oop.g8.model.relation.person.P2O;
import oop.g8.model.relation.person.P2P;

@Service
public class InitDB {

	@Autowired
	private Wrap w;

	@Autowired
	private ScannerService scn;

	private DataService data = new DataService();

	public void addData() {
		System.out.println("---Sinh dữ liệu giả lập---");
		System.out.print("->Số lượng thực thể: ");
		int e = scn.getInputNum(100000000);

		System.out.print("->Số lượng quan hệ: ");
		int r = scn.getInputNum(100000000);
		System.out.println("    Sinh " + e + " thực thể và " + r + " quan hệ");

		int outterLoop1 = e / 6000;
		int outterLoop2 = r / 6000;
		
		long start = System.currentTimeMillis();

////////////////////////////////////////////////////////////////////////////
		List<Person> pL1 = new ArrayList<>();
		List<Person> pL = new ArrayList<>();
		long s = System.currentTimeMillis();
		for (int i = 0; i < outterLoop1; i++) {
			for (int j = 0; j < 1000; j++) {
				Person p = PersonGenerator.generatePerson();
				pL.add(p);
				pL1.add(p);
			}
			w.pr.saveAll(pL);
			System.out.println("save Person " + i + "x1000 !");
			pL.clear();
		}
		long f = System.currentTimeMillis();
		System.out.println("time generate Person:" + (f - s));

////////////////////////////////////////////////////////////////////////////
		s = System.currentTimeMillis();
		List<Organization> oL1 = new ArrayList<>();
		List<Organization> oL = new ArrayList<>();
		for (int i = 0; i < outterLoop1; i++) {
			for (int j = 0; j < 1000; j++) {
				Organization o = OrganizationGenerator.generateOrganization();
				oL.add(o);
				oL1.add(o);
			}
			w.or.saveAll(oL);
			System.out.println("save Organization " + i + "x1000 !");
			oL.clear();
		}
		f = System.currentTimeMillis();
		System.out.println("time generate Country:" + (f - s));

////////////////////////////////////////////////////////////////////////////		
		s = System.currentTimeMillis();
		List<Location> lL1 = new ArrayList<>();
		List<Location> lL = new ArrayList<>();
		for (int i = 0; i < outterLoop1; i++) {
			for (int j = 0; j < 1000; j++) {
				Location l = LocationGenerator.generateLocation();
				lL.add(l);
				lL1.add(l);
			}
			w.lr.saveAll(lL);
			System.out.println("save Location " + i + "x1000 !");
			lL.clear();
		}
		f = System.currentTimeMillis();
		System.out.println("time generate Location:" + (f - s));

////////////////////////////////////////////////////////////////////////////
		s = System.currentTimeMillis();
		List<Country> cL1 = new ArrayList<>();
		List<Country> cL = new ArrayList<>();
		for (int i = 0; i < outterLoop1; i++) {
			for (int j = 0; j < 1000; j++) {
				Country c = CountryGenerator.generateCountry();
				cL1.add(c);
				cL.add(c);
			}
			w.cr.saveAll(cL);
			System.out.println("save Country " + i + "x1000 !");
			cL.clear();
		}
		f = System.currentTimeMillis();
		System.out.println("time generate Location:" + (f - s));

////////////////////////////////////////////////////////////////////////////	
		s = System.currentTimeMillis();
		List<Event> eL1 = new ArrayList<>();
		List<Event> eL = new ArrayList<>();
		for (int i = 0; i < outterLoop1; i++) {
			for (int j = 0; j < 1000; j++) {
				Event e11 = EventGenerator.generateEvent();
				eL.add(e11);
				eL1.add(e11);
			}
			w.er.saveAll(eL);
			System.out.println("save Event" + i + "x1000 !");
			eL.clear();
		}
		f = System.currentTimeMillis();
		System.out.println("time generate Event:" + (f - s));

////////////////////////////////////////////////////////////////////////////
		s = System.currentTimeMillis();
		List<Time> tL1 = new ArrayList<>();
		List<Time> tL = new ArrayList<>();
		for (int i = 0; i < outterLoop1; i++) {
			for (int j = 0; j < 1000; j++) {
				Time t = TimeGenerator.generateTime();
				tL.add(t);
				tL1.add(t);
			}
			w.tr.saveAll(tL);
			System.out.println("save Time" + i + "x1000 !");
			tL.clear();
		}
		f = System.currentTimeMillis();
		System.out.println("time generate Event:" + (f - s));

		List<P2P> ppL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				P2P p2p = P2PG.generateP2P(pL1.get((int) (Math.random() * pL1.size())),
						pL1.get((int) (Math.random() * pL1.size())),
						data.p2p.get((int) Math.random() * data.p2p.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				ppL.add(p2p);
			}
			w.ppr.saveAll(ppL);
			System.out.println("save P2P" + i + "x1000 !");
			ppL.clear();
		}

		List<P2C> pcL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				P2C p2c = P2CG.generateP2C(pL1.get((int) (Math.random() * pL1.size())),
						cL1.get((int) (Math.random() * cL1.size())),
						data.p2c.get((int) Math.random() * data.p2c.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				pcL.add(p2c);
			}
			w.pcr.saveAll(pcL);
			System.out.println("save P2C" + i + "x1000 !");
			pcL.clear();
		}

		List<P2O> poL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				P2O p2o = P2OG.generateP2O(pL1.get((int) (Math.random() * pL1.size())),
						oL1.get((int) (Math.random() * oL1.size())),
						data.p2o.get((int) Math.random() * data.p2o.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				poL.add(p2o);
			}
			w.por.saveAll(poL);
			System.out.println("save P2O" + i + "x1000 !");
			poL.clear();
		}

		List<O2E> oeL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				O2E o2e = O2EG.generateO2E(oL1.get((int) (Math.random() * oL1.size())),
						eL1.get((int) (Math.random() * eL1.size())),
						data.o2e.get((int) Math.random() * data.o2e.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				oeL.add(o2e);
			}
			w.oer.saveAll(oeL);
			System.out.println("save O2E" + i + "x1000 !");
			oeL.clear();
		}

//		List<O2L> olL = new ArrayList<>();
//		for (int i = 0; i < outterLoop2; i++) {
//			for (int j = 0; j < 1000; j++) {
//				P2P o2l = O2LG.generateO2L(oL1.get((int) (Math.random() * oL1.size())), lL1.get((int) (Math.random() * lL1.size())),
//						data.o2l.get((int) Math.random()*data.o2l.size() ) , SourceGenerator.randomLink(), SourceGenerator.randomDate());
//				ppL.add(o2l);
//			}
//			w.olr.saveAll(olL);
//			System.out.println("save Time" + i + "x1000 !");
//			olL.clear();
//		}

		List<L2E> leL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				L2E l2e = L2EG.generateL2E(lL1.get((int) (Math.random() * lL1.size())),
						eL1.get((int) (Math.random() * eL1.size())),
						data.e2l.get((int) Math.random() * data.e2l.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				leL.add(l2e);
			}
			w.ler.saveAll(leL);
			System.out.println("save L2E" + i + "x1000 !");
			leL.clear();
		}

//		List<C2E> ceL = new ArrayList<>();
//		for (int i = 0; i < outterLoop2; i++) {
//			for (int j = 0; j < 1000; j++) {
//				C2E c2e = C2EG.generateC2E(lL1.get((int) (Math.random() * lL1.size())), pL1.get((int) (Math.random() * pL1.size())),
//						data.c2e.get((int) Math.random()*data.c2e.size() ) , SourceGenerator.randomLink(), SourceGenerator.randomDate());
//				ceL.add(c2e);
//			}
//			w.cer.saveAll(ceL);
//			System.out.println("save Time" + i + "x1000 !");
//			ceL.clear();
//		}

		List<E2O> eoL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				E2O e2o = E2OG.generateE2O(eL1.get((int) (Math.random() * eL1.size())),
						oL1.get((int) (Math.random() * oL1.size())),
						data.e2l.get((int) Math.random() * data.e2l.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				eoL.add(e2o);
			}
			w.eor.saveAll(eoL);
			System.out.println("save E2O" + i + "x1000 !");
			eoL.clear();
		}

		List<E2L> elL = new ArrayList<>();
		for (int i = 0; i < outterLoop2; i++) {
			for (int j = 0; j < 1000; j++) {
				E2L e2l = E2LG.generateE2L(eL1.get((int) (Math.random() * eL1.size())),
						lL1.get((int) (Math.random() * lL1.size())),
						data.e2l.get((int) Math.random() * data.e2l.size()), SourceGenerator.randomLink(),
						SourceGenerator.randomDate());
				elL.add(e2l);
			}
			w.elr.saveAll(elL);
			System.out.println("save E2L" + i + "x1000 !");
			elL.clear();
		}
		
		long finish = System.currentTimeMillis();
		
		long total = finish - start;
		System.out.println("Total time: " + total );
	}
	
	
	

}
