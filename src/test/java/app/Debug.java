package app;

import app.dao.platform.PlatformMenuDao;
import app.dao.platform.QuanwaiUtilsDao;
import app.dao.pro.ProLessonPackageDao;
import app.dao.test.TestAccessTokenDao;
import app.dao.pro.ProAccessTokenDao;
import app.entity.*;
import app.service.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Test
@SpringBootTest
public class Debug extends AbstractTestNGSpringContextTests {
    @Autowired
    private TestAccessTokenDao testAccessTokenDao;

    @Autowired
    private ProAccessTokenDao proAccessTokenDao;

    @Autowired
    private PlatformMenuDao platformMenuDao;

    @Autowired
    private PlatformMenuService platformMenuService;
    @Test
    public void getAll() {
//        proAccessTokenDao.getAllTokenContent();
//        PlatformMenu platformMenu = platformMenuDao.queryById(1);
//        System.out.println(platformMenu);
        List<PlatformMenu> platformMenuList = platformMenuService.getAllMenu();
        for (PlatformMenu menu: platformMenuList
             ) {
            System.out.println(menu);
        }
    }
    
    @Value("${spring.datasource.test.url}")
    public void setUrl(String url){
        dataSourceUrl = url;
    }

    private static String dataSourceUrl;


    @Test
    public void test(){
        System.out.println(dataSourceUrl);
    }

    @Autowired
    private TermTimetableService termTimetableService;

    @Autowired
    private QuanwaiUtilsService quanwaiUtilsService;

    @Autowired
    private LessonPackageService lessonPackageService;

    @Autowired
    private TermScheduleService termScheduleService;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ClassMemberRegistrationService classMemberRegistrationService;

    @Autowired
    private ProLessonPackageDao proLessonPackageDao;

    @Test
    public void test1(){
//        LessonPackage lessonPackage =  lessonPackageService.queryById(1);
//        TermSchedule termSchedule = termScheduleService.queryById(83);
//        System.out.println(lessonPackage);
//        System.out.println(termSchedule);
//        System.out.println(userInfoService.getUserByPassportId(977137).toString());
//        ClassMemberRegistration classMemberRegistration = new ClassMemberRegistration();
//        classMemberRegistration.setPassportId(977137);
//        classMemberRegistration.setLessonPackageId(1);
//        classMemberRegistration.setTermScheduleId(394);
//        ClassMemberRegistration insertClassMemberRegistration = classMemberRegistrationService.insert(classMemberRegistration);
//        System.out.println(insertClassMemberRegistration);
//        BM1629440013   B9995929   977137
//        classMemberRegistrationService.resetRegistration(977137,"BLQB80410001","B0299838");
//        List<ClassMemberRegistration> classMemberRegistrations = classMemberRegistrationService.getRegistrationByPassportId(977137);
//        classMemberRegistrationService.getUserLessonInfoByRegistration(classMemberRegistrations).forEach(System.out::println);
        System.out.println(System.getProperty("user.dir"));
    }



    @Test
    public void test2(){
        String str = "eureka.client.service-url.defaultZone = ${EUREKA_SERVICE_URL:https://eureka.iquanwai.com}/eureka/\n" +
                "eureka.instance.prefer-ip-address = true\n" +
                "spring.zipkin.base-url = http://47.101.4.42:9411\n" +
                "spring.sleuth.sampler.probability = 1.0\n" +
                "eureka.instance.lease-expiration-duration-in-seconds = 30\n" +
                "eureka.instance.lease-renewal-interval-in-seconds = 10\n" +
                "db.online.url = jdbc:mysql://rm-uf6b9zyc22b6j1td6.mysql.rds.aliyuncs.com:3306\n" +
                "db.online.password = KFef*Wq5Lc5W7Nd0\n" +
                "db.online.name = quanwai\n" +
                "redis.single.password = UKx=BmN~nor!ueSt\n" +
                "redis.single.address = 172.19.10.215:6739\n" +
                "rabbitmq.password = hHqrWagilVXGY4Mh\n" +
                "rabbitmq.name = quanwai\n" +
                "rabbitmq.address = 172.19.10.215:55672,172.19.10.223:55672\n" +
                "redis.address = r-uf60q84l2dcbhi3518.redis.rds.aliyuncs.com:6379\n" +
                "redis.password = HvaZe5vcbqETEbTQ\n" +
                "yz.clientId = f3f4b2ff18ea3147b8\n" +
                "yz.clientSecret = 6a6a117301983f1b7a94b3f5d1c33e46\n" +
                "yz.ktdId = 40894156";
        String str1 = "rabbitmq.password = hHqrWagilVXGY4Mh\n" +
                "rabbitmq.name = quanwai\n" +
                "rabbitmq.address = 172.19.10.215:55672,172.19.10.223:55672\n" +
                "redis.address = r-uf60q84l2dcbhi3518.redis.rds.aliyuncs.com:6379\n" +
                "redis.password = HvaZe5vcbqETEbTQ\n" +
                "yz.clientId = f3f4b2ff18ea3147b8\n" +
                "yz.clientSecret = 6a6a117301983f1b7a94b3f5d1c33e46\n" +
                "yz.ktdId = 40894156";
        String [] strings = str.split("\n");
        String newStr = null;
        for (String s : strings) {
//            newStr = s.substring(0,s.indexOf(" ="));
//            System.out.println(newStr);
            System.out.println(s);
        }
    }

    @Test
    public void test05(){
        List<String> list = new ArrayList<>();
//        list.add("BE620041");
//        list.add("DE209373");
        String code = "";
        proLessonPackageDao.getPackageAcquireRules("BE420377",null);
    }



}
