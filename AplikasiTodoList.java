/**
 * AplikasiTodoList
 */
public class AplikasiTodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();

    }

    /**
     * Menampilkan Todo List
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            String todo = model[i];
            var number = i + 1;

            if (todo != null) {
                System.out.println(number + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar java Dasar";
        model[1] = "Membuat todo list";
        showTodoList();
    }

    /**
     * Menambahkan Todo ke List
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita rezise ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi data array yang null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo ke " + i);
        }
        showTodoList();
    }

    /**
     * Menghapus Todo dari List
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {

            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var chanel = input("Channel");
        System.out.println(chanel);
    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            System.out.println(" =========== ");
            System.out.println("| TODOLIST  |");
            System.out.println(" =========== ");
            
            showTodoList();
            
            System.out.println("Menu : ");
            System.out.println("Ketik 1 untuk Tambah");
            System.out.println("ketik 2 untuk Hapus");
            System.out.println("Ketik x untuk keluar");
            
            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            }else if (input.equals("x")){
                break;
            }else{
                System.out.println("Inputan tidak valid!");
            }
        }
    }

    public static void testViewShowTodoList(){
        System.out.println(" =========== ");
        System.out.println("| TODOLIST  |");
        System.out.println(" =========== ");

        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");
        var todo = input("Todo (x Jika batal)");

        if (todo.equals("x")) {
            //batal
        }else{
            addTodoList(todo);
        }
    }
    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilakn view menghapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Ketik nomor yang mau Dihapus ( x jika Batal )");

        if (number.equals("x")) {
            //batal
        }else{
          boolean success =  removeTodoList(Integer.valueOf(number));
          if(!success){
            System.out.println("Gagal menghapus todolist : " + number);
          }
        }
    }

    public static void testViewTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}