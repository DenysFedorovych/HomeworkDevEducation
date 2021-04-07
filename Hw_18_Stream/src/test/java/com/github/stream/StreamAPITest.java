package com.github.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamAPITest {

    private static List<Student> studentsMany = new LinkedList<>();
    private static List<Student> studentsTwo = new LinkedList<>();
    private static List<Student> studentsOne = new LinkedList<>();
    private static List<Student> studentsZero = new LinkedList<>();

    private static StreamAPI streamAPI = new StreamAPI();

    static {
        Collections.addAll(studentsMany, new Student(1, "DD", "ff", 2002, "Kyiv", "+380680584460", "Phys", "Second", "5b"),
                new Student(2, "SS", "YY", 2002, "Kyiv", "+380672000000", "Cyber", "Second", "K27"),
                new Student(3, "BB", "KK", 2001, "Dnipro", "+380630584460", "Phys", "Second", "12"),
                new Student(4, "LL", "QQ", 2001, "Nyko", "+380650584460", "Med", "Second", "2"),
                new Student(5, "MM", "EE", 2000, "Nyko", "+380690584460", "Law", "First", "4"),
                new Student(6, "CC", "TT", 2003, "Lviv", "+380730584460", "Phys", "First", "66"),
                new Student(7, "NN", "UU", 2001, "Canada", "+380550584460", "Med", "Second", "1"),
                new Student(8, "AA", "II", 1999, "Akadem", "+380220584460", "Med", "Third", "5a"));
        Collections.addAll(studentsTwo,
                new Student(2, "NN", "YY", 1992, "Kyiv", "+380672000000", "Law", "Second", "55"),
                new Student(6, "CC", "TT", 2003, "Lviv", "+380730584460", "Phys", "First", "66"));
        Collections.addAll(studentsOne, new Student(7, "NN", "UU", 2001, "Canada", "+380550584460", "Med", "Second", "1"));
    }

    // ================================================================================
// =============================Faculty Students===================================
// ================================================================================
    @Test
    public void facultyStudentsMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(3, streamAPI.facultyStudents("Phys").size());
    }

    @Test
    public void facultyStudentsTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(1, streamAPI.facultyStudents("Phys").size());
    }

    @Test
    public void facultyStudentsOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(0, streamAPI.facultyStudents("Phys").size());
    }

    @Test
    public void facultyStudentsZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(0, streamAPI.facultyStudents("Phys").size());
    }

// ================================================================================
// ================================After Year======================================
// ================================================================================


    @Test
    public void afterYearMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(1, streamAPI.afterYear(2002).size());
    }

    @Test
    public void afterYearTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(1, streamAPI.afterYear(2002).size());
    }

    @Test
    public void afterYearOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(0, streamAPI.afterYear(2002).size());
    }

    @Test
    public void afterYearZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(0, streamAPI.afterYear(2002).size());
    }

    // ================================================================================
    // ==============================After Year One====================================
    // ================================================================================

    @Test
    public void afterYearOneStudentMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(studentsMany.get(0),streamAPI.afterYearOneStudent(2001));
    }

    @Test
    public void afterYearOneStudentTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(studentsTwo.get(1),streamAPI.afterYearOneStudent(2000));
    }

    @Test(expected = NoSuchElementException.class)
    public void afterYearOneStudentOne() {
        streamAPI.init(studentsOne);
        streamAPI.afterYearOneStudent(2001);
    }

    @Test(expected = NoSuchElementException.class)
    public void afterYearOneStudentZero() {
        streamAPI.init(studentsZero);
        streamAPI.afterYearOneStudent(2001);
    }

    // ================================================================================
    // ==================================Group=========================================
    // ================================================================================

    @Test
    public void groupMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(1, streamAPI.group("5b").size());
    }

    @Test
    public void groupTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(1, streamAPI.group("55").size());
    }

    @Test
    public void groupOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(0, streamAPI.group("5b").size());
    }

    @Test
    public void groupZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(0, streamAPI.group("5b").size());
    }

    // ================================================================================
    // ===========================Students by faculty==================================
    // ================================================================================

    @Test
    public void studentsByFacultyMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(3,streamAPI.studentsByFaculty("Phys"));
    }

    @Test
    public void studentsByFacultyTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(1,streamAPI.studentsByFaculty("Phys"));
    }

    @Test
    public void studentsByFacultyOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(0,streamAPI.studentsByFaculty("Phys"));
    }

    @Test
    public void studentsByFacultyZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(0,streamAPI.studentsByFaculty("Phys"));
    }

    // ================================================================================
    // =============================To special format==================================
    // ================================================================================

    @Test
    public void toSpecialFormatMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals("DD, ff - Phys, 5b\n" +
                "SS, YY - Cyber, K27\n" +
                "BB, KK - Phys, 12\n" +
                "LL, QQ - Med, 2\n" +
                "MM, EE - Law, 4\n" +
                "CC, TT - Phys, 66\n" +
                "NN, UU - Med, 1\n" +
                "AA, II - Med, 5a",streamAPI.toSpecialFormat());
    }

    @Test
    public void toSpecialFormatTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals("NN, YY - Law, 55\n" +
                "CC, TT - Phys, 66",streamAPI.toSpecialFormat());
    }

    @Test
    public void toSpecialFormatOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals("NN, UU - Med, 1",streamAPI.toSpecialFormat());
    }

    @Test
    public void toSpecialFormatZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals("",streamAPI.toSpecialFormat());
    }

    // ================================================================================
    // ============================Grouping by faculty=================================
    // ================================================================================

    @Test
    public void groupingByFacultyMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(3,streamAPI.groupingByFaculty().get("Phys").size());
    }

    @Test
    public void groupingByFacultyTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(1,streamAPI.groupingByFaculty().get("Phys").size());
    }

    @Test
    public void groupingByFacultyOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(1,streamAPI.groupingByFaculty().get("Med").size());
    }

    @Test
    public void groupingByFacultyZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(0,streamAPI.groupingByFaculty().size());
    }

    // ================================================================================
    // =============================Grouping by course=================================
    // ================================================================================

    @Test
    public void groupingByCourseMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(5,streamAPI.groupingByCourse().get("Second").size());
    }

    @Test
    public void groupingByCourseTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(1,streamAPI.groupingByCourse().get("Second").size());
    }

    @Test
    public void groupingByCourseOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(1,streamAPI.groupingByCourse().get("Second").size());
    }

    @Test
    public void groupingByCourseZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(0,streamAPI.groupingByCourse().size());
    }

    // ================================================================================
    // ================================if one faculty==================================
    // ================================================================================

    @Test
    public void ifOneFacultyMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(false,streamAPI.ifOneFaculty("Phys"));
    }

    @Test
    public void ifOneFacultyTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(false,streamAPI.ifOneFaculty("Phys"));
    }

    @Test
    public void ifOneFacultyOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(true,streamAPI.ifOneFaculty("Med"));
    }

    @Test
    public void ifOneFacultyZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(false,streamAPI.ifOneFaculty("Phys"));
    }

    // ================================================================================
    // ================================if one Group===================================
    // ================================================================================

    @Test
    public void ifOneGroupMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(false,streamAPI.ifOneGroup("5b"));
    }

    @Test
    public void ifOneGroupTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(false,streamAPI.ifOneGroup("55"));
    }

    @Test
    public void ifOneGroupOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(true,streamAPI.ifOneGroup("1"));
    }

    @Test
    public void ifOneGroupZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(false,streamAPI.ifOneGroup("5b"));
    }

    // ================================================================================
    // ==============================if one on faculty=================================
    // ================================================================================

    @Test
    public void ifOneOnFacultyMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(true,streamAPI.ifOneOnFaculty("Phys"));
    }

    @Test
    public void ifOneOnFacultyTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(true,streamAPI.ifOneOnFaculty("Phys"));
    }

    @Test
    public void ifOneOnFacultyOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(false,streamAPI.ifOneOnFaculty("Phys"));
    }

    @Test
    public void ifOneOnFacultyZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(false,streamAPI.ifOneOnFaculty("Phys"));
    }

    // ================================================================================
    // ===============================if one in group==================================
    // ================================================================================

    @Test
    public void ifOneInGroupMany() {
        streamAPI.init(studentsMany);
        Assert.assertEquals(true,streamAPI.ifOneInGroup("5b"));
    }

    @Test
    public void ifOneInGroupTwo() {
        streamAPI.init(studentsTwo);
        Assert.assertEquals(false,streamAPI.ifOneInGroup("57"));
    }

    @Test
    public void ifOneInGroupOne() {
        streamAPI.init(studentsOne);
        Assert.assertEquals(true,streamAPI.ifOneInGroup("1"));
    }

    @Test
    public void ifOneInGroupZero() {
        streamAPI.init(studentsZero);
        Assert.assertEquals(false,streamAPI.ifOneInGroup("5b"));
    }
}