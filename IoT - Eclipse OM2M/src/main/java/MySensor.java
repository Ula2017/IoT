import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;
 
public class MySensor {
 
	public static int sensorValue;
 
	private static String originator="admin:admin";
	private static String cseProtocol="http";
	private static String cseIp = "172.20.10.10";
	private static int csePort = 8080;
	private static String cseId = "mn-cse";
	private static String cseName = "mn-name";
 
	private static String aeName = "mysensor";
	private static String cntName = "data";
 
	private static String csePoa = cseProtocol+"://"+cseIp+":"+csePort;
 
	public static void main(String[] args) {
 
		JSONObject obj = new JSONObject();
		obj.put("rn", aeName);
		obj.put("api", 12345);
		obj.put("rr", false);
		JSONObject resource = new JSONObject();
		resource.put("m2m:ae", obj);
		RestHttpClient.post(originator, csePoa+"/~/"+cseId+"/"+cseName, resource.toString(), 2);
 
	        obj = new JSONObject();
	        obj.put("rn", cntName);
		resource = new JSONObject();
	        resource.put("m2m:cnt", obj);
		RestHttpClient.post(originator, csePoa+"/~/"+cseId+"/"+cseName+"/"+aeName, resource.toString(), 3);
 
		while (true){
 
			obj = new JSONObject();
			obj.put("cnf", "application/text");
			obj.put("con", getSensorValue());
			resource = new JSONObject();
			resource.put("m2m:cin", obj);
			RestHttpClient.post(originator, csePoa+"/~/"+cseId+"/"+cseName+"/"+aeName+"/"+cntName, resource.toString(), 4);
 
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
 
	public static int index = 0;
 
	public static int getSensorValue(){
		List<Integer> temp = Arrays.asList(3, 7, 30, 40, 20);
		sensorValue = temp.get(index);
		index = (index + 1) % temp.size();
		System.out.println("Sensor value = "+sensorValue);
		return sensorValue;
	}
}