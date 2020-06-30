package app;

import app.dao.platform.PlatformMenuDao;
import app.dao.platform.QuanwaiUtilsDao;
import app.dao.test.TestAccessTokenDao;
import app.dao.pro.ProAccessTokenDao;
import app.entity.*;
import app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

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
        List<ClassMemberRegistration> classMemberRegistrations = classMemberRegistrationService.getRegistrationByPassportId(977137);
        classMemberRegistrationService.getUserLessonInfoByRegistration(classMemberRegistrations).forEach(System.out::println);
    }
}
