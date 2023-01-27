/*Klavyden aşağıdaki formatta alınan bilgiyi ayrıştırarak ekrana sonuçları yazdıran programı
	aşağıdaki açıklamalar göre yazınız:
	<ad soyad>:<ders adı>:<gg-aa-yyyy>:>:<gg-aa-yyyy><arasınav notu>:<final notu>
	Mehmet Yıldırım:Matematik:04-05-2022:04-06-2022:40:35*/
package org.csystem.app;
import static  org.csystem.app.myCODER.Kodlarım.*;
import java.util.Scanner;
class App {
    public static void main(String [] args)
    {
        LectureStudentInfoParserApp.run();
    }
}
class LectureStudentInfoParserApp {
    public static void printReport(LectureStudentInfo info)
    {
        int grade = info.getGrade();

        System.out.println("--------------------------------------------------");
        System.out.printf("Adı Soyadı: %s%n", info.studentName);
        System.out.printf("Ders Adı: %s%n", info.lectureName);
        System.out.printf("Arasınav Tarihi: %s%n", info.midtermDate);
        System.out.printf("Final Tarihi: %s%n", info.finalDate);
        System.out.printf("Arasınav Notu: %d%n", info.midTermGrade);
        System.out.printf("Final Notu: %d%n", info.finalGrade);
        System.out.printf("Geçme Notu: %d%n", grade);
        System.out.printf("Sonuç: %s%n", grade >= 50 ? "Geçti" : "Kaldı");
        System.out.println("--------------------------------------------------");

     }
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for(;;) {
            System.out.println("Formatlı yazıyı giriniz");
            String str = kb.nextLine().strip();
            if("elma".equals(str))
                break;

            LectureStudentInfoParser parser = new LectureStudentInfoParser(str);
            printReport(parser.LectureStudentInfo);
        }
    }
}
class LectureStudentInfo {
    public String studentName;
    public String lectureName;
    public String midtermDate;
    public String finalDate;

    public int midTermGrade;
    public int finalGrade;

    public int getGrade()
    {
        return (int)Math.round(midTermGrade * 0.4 + finalGrade * 0.6);
    }
}

class LectureStudentInfoParser {
    public LectureStudentInfo LectureStudentInfo;

    public static String getDateStr(String str)
    {
        String [] dateInfo = str.split("[-]");

        int day = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int year = Integer.parseInt(dateInfo[2]);

        return getDateStrTR(day, month, year);
    }

    public LectureStudentInfoParser(String dataStr)
    {
        String [] LectureStudentInfoStr = dataStr.split("[:]+");

        LectureStudentInfo = new LectureStudentInfo();

        LectureStudentInfo.studentName = LectureStudentInfoStr[0];
        LectureStudentInfo.lectureName = LectureStudentInfoStr[1];
        LectureStudentInfo.midtermDate = getDateStr(LectureStudentInfoStr[2]);
        LectureStudentInfo.finalDate   = getDateStr(LectureStudentInfoStr[3]);
        LectureStudentInfo.midTermGrade = Integer.parseInt(LectureStudentInfoStr[4]);
        LectureStudentInfo.finalGrade = Integer.parseInt(LectureStudentInfoStr[5]);
    }

    public static String getDateStrTR(int day, int month, int year)
    {
        String str = DateApp(day,month,year);
        System.out.println(str);
       return DateApp(day, month, year);
    }
}