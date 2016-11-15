package parsers;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttException;

public final class Parsers {
	
	
	
	public static MQTTParser mqttParser; 
	
	public static final MQTTParser getParserSingleton() {
		
		if (mqttParser == null) {
			mqttParser = new MQTTParser();
		}
		
		return mqttParser;		
	}
			
	public static void main(String[] args) throws InterruptedException, IOException, MqttException {
		
		Parsers.getParserSingleton();	
		
		while(true) {
						
			Double[][] data = mqttParser.mqttParser.getMessageTimeout("overhead_tracker/all_robot_pose_data", 1000).message;
			
			for (int i = 0; i < data[0].length; i++) {
												
				System.out.println(data[0][i] + " "  + data[1][i] + " "  + data[2][i] + " " + data[3][i] + " " + data[4][i]);
				
				Double[] input = {(double) 0.1, (double) 3};
				
				System.out.println(data[0][i].intValue());
				
				String specificRobotChannel = mqttParser.robotChannel + "/" + mqttParser.alias.get(Integer.toString(data[0][i].intValue()));
				
				System.out.println(specificRobotChannel);
				
				mqttParser.mqttParser.sendMessage(specificRobotChannel, input);
			}					
		}
	}
}
