public class Transformation {
    private int minTemp;
    private int maxTemp;
    private int minReturnValue;
    private int maxReturnValue;

    public Transformation(){
        this(0,30,3,40);
    }

    public Transformation(int minTemp, int maxTemp, int minReturnValue, int maxReturnValue) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.minReturnValue = minReturnValue;
        this.maxReturnValue = maxReturnValue;
    }


    public int transform(double val){
        return this.transform((int) val);
    }

    public int transform(int val){
        val = (val<this.minTemp)?this.minTemp:val;
        val = (val>this.maxTemp)?this.maxTemp:val;

        val -= this.minTemp;
        val *= (this.maxReturnValue - this.minReturnValue);
        val /= (this.maxTemp - this.minTemp);
        val += this.minReturnValue;
        return val;
    }

}
