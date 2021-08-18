class Calendar
{
    public enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};

    public static void main(String[] args)
    {
        Day lectureDay, labDay;

        System.out.println(Day.SUNDAY + "\t\t" + Day.MONDAY + "\t\t" + Day.TUESDAY + "\t\t" + Day.WEDNESDAY + "\t\t" + Day.THURSDAY + "\t\t" + Day.FRIDAY + "\t\t" + Day.SATURDAY);

        lectureDay = Day.MONDAY;
        labDay = Day.TUESDAY;

        System.out.println("\t\tLecture 12:30\tLab 08:30");
        
        System.out.println("My lecture day is " + lectureDay);
        System.out.println("My lab day is " + labDay);
    }
}
