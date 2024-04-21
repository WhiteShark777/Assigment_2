public class Application {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        fillList(list);
        list.addFirst("London");
        printList(list);
    }
    public static void fillList(MyList<String> list){
        list.add("Aqtobe");
        list.add("Astana");
        list.add("Almaty");
    }
    public static void printList(MyList<String> list){
        list.forEach(System.out::println);
    }
}
