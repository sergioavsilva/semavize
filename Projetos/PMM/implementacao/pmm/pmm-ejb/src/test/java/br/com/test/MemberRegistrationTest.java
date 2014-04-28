package br.com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.semavize.pmm.mail.model.Evento;
import br.com.semavize.pmm.mailpackage.model.Package;
import br.com.semavize.pmm.tracking.Tracking;
import br.com.semavize.pmm.tracking.impl.TrackingImpl;

@RunWith(Arquillian.class)
public class MemberRegistrationTest {

	@Deployment
	public static Archive<?> createTestArchive() {

		MavenDependencyResolver resolver = DependencyResolvers.use(
				MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");

		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(Package.class)
				.addPackages(true, "br.com.jventura")
				.addPackages(true, "br.com.semavize")
				.addAsLibraries(resolver.artifact("org.primefaces:primefaces:jar:3.4.2").resolveAsFiles())
				.addAsLibraries(resolver.artifact("joda-time:joda-time").resolveAsFiles())
				.addAsLibraries(resolver.artifact("org.jadira.usertype:usertype.core").resolveAsFiles())
				.addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@PersistenceContext(name = "PMMDS")
	EntityManager em;
	
	@Inject
	Tracking trk;
	
	@Inject
	UserTransaction utx;

	@Inject
	Logger log;

	@Test
	public void testRegister() throws Exception {

		System.out.println("Init....\n\n");

		LocalDateTime localDateTime = new LocalDateTime(2013, 05, 01, 0, 0);

		Package pck = new Package(localDateTime, "codServico", "rPostagem","pesoPostagem", "cepDeOrigem", "cepDestino", "nomeDestinatario");

		Evento evento = new Evento();	
		
		utx.begin();
		em.joinTransaction();		
		
		HashMap<String, Package> pkg = getPackages();
		Set<Map.Entry<String, Package>> lpck = pkg.entrySet();		
		
		utx.commit();
	}

	private HashMap<String, Package> getPackages() {

		File input = new File("/home/henrique/Downloads/CORRECAO_POSTAG_PARA_RECOVER_V.CSV");


		HashMap<String, Package> pks = null;
	
		try {
			
			trk.setEm(em);
			
			pks = trk.fileUploadTrackingNumbers(new FileInputStream(input));
			
			trk.trackingSearch(pks);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return pks;
	}

}
