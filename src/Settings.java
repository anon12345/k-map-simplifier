
public class Settings {
    private static boolean REALTIME_GRAPHICS = false;

    public static boolean getRealtime(){
        return REALTIME_GRAPHICS;
    }

    public static void toggleRealtime(){
        REALTIME_GRAPHICS = !REALTIME_GRAPHICS;
    }
}
