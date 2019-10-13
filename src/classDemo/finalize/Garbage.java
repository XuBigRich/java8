package classDemo.finalize;

public class Garbage {
    public static void main(String[] args) {
        while(!Chair.f){
            new Chair();
            new String("To take up space");
        }
        System.out.println(
                "After all Chairs have been created :\n"+
                        "total created = "+Chair.created+
                        ",total finalized = "+Chair.finalized
        );
        if(args.length>0){
            if(args[0].equals("gc")||args[0].equals("all")){
                System.out.println("runFinalization():");
                System.runFinalization();
            }
        }
        System.out.println("bye!");
    }
}
