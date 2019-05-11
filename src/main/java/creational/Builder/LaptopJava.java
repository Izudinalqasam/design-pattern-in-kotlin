package creational.Builder;

public class LaptopJava {

    private String HDD;
    private String RAM;

    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private LaptopJava(LaptopJavaBuilder builder){
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "LaptopJava{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    public static class LaptopJavaBuilder{

        private String HDD;
        private String RAM;

        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public LaptopJavaBuilder(String hdd, String ram){
            this.HDD = hdd;
            this.RAM = ram;
        }

        public LaptopJavaBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            this.isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public LaptopJavaBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public LaptopJava build(){
            return new LaptopJava(this);
        }
    }
}
