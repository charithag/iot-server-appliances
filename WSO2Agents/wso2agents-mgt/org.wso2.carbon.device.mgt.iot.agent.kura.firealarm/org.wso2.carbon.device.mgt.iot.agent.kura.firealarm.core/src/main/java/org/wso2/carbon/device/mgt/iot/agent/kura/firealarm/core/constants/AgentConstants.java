/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.iot.agent.kura.firealarm.core.constants;

import java.io.File;

public class AgentConstants {
	public static final String DEVICE_TYPE = "firealarm";

	private static final String FILE_SEPERATOR = File.separator;
	public static final String LOG_APPENDER = "AGENT_LOG:: ";
	public static final String PROPERTIES_FILE_PATH =
			"." + FILE_SEPERATOR + "repository" + FILE_SEPERATOR + "conf" + FILE_SEPERATOR;
	public static final int DEFAULT_RETRY_THREAD_INTERVAL = 5000;        // time in millis

	/*	---------------------------------------------------------------------------------------
								IoT-Server specific information
 		---------------------------------------------------------------------------------------	*/
	public static final String DEVICE_CONTROLLER_API_EP = "/firealarm/controller";
	public static final String DEVICE_REGISTER_API_EP = "/register";
	public static final String DEVICE_PUSH_TEMPERATURE_API_EP = "/push_temperature";
	public static final String PUSH_DATA_PAYLOAD =
			"{\"owner\":\"%s\",\"deviceId\":\"%s\",\"reply\":\"%s\",\"value\":\"%s\"}";

	/*	---------------------------------------------------------------------------------------
				HTTP Connection specific information for communicating with IoT-Server
 		---------------------------------------------------------------------------------------	*/
	public static final String HTTP_PREFIX = "http://";
	public static final String HTTP_POST = "POST";
	public static final String HTTP_GET = "GET";
	public static final String APPLICATION_JSON_TYPE = "application/json";

	public static final int DEVICE_SERVER_PORT = 9090;

	/*	---------------------------------------------------------------------------------------
								MQTT Connection specific information
 		---------------------------------------------------------------------------------------	*/
	public static final int DEFAULT_MQTT_RECONNECTION_INTERVAL = 2;        // time in seconds
	public static final int DEFAULT_MQTT_QUALITY_OF_SERVICE = 0;
	public static final String MQTT_SUBSCRIBE_TOPIC = "wso2/iot/%s/" + DEVICE_TYPE + "/%s";
	public static final String MQTT_TEMP_PUBLISH_TOPIC = "wso2/iot/%s/" + DEVICE_TYPE + "/%s/temp";
	public static final String MQTT_HUMID_PUBLISH_TOPIC =
			"wso2/iot/%s/" + DEVICE_TYPE + "/%s/humid";

	/*	---------------------------------------------------------------------------------------
								XMPP Connection specific information
 		---------------------------------------------------------------------------------------	*/
	public static final String XMPP_ADMIN_ACCOUNT_UNAME = "admin";

	/*	---------------------------------------------------------------------------------------
		  Device/Agent specific properties to be read from the 'deviceConfig.properties' file
 		---------------------------------------------------------------------------------------	*/
	public static final String AGENT_PROPERTIES_FILE_NAME = "deviceConfig.properties";

	public static final String DEVICE_OWNER_PROPERTY = "owner";
	public static final String DEVICE_ID_PROPERTY = "deviceId";
	public static final String IOT_SERVER_EP_PROPERTY = "server-ep";
	public static final String MQTT_BROKER_EP_PROPERTY = "mqtt-ep";
	public static final String XMPP_SERVER_EP_PROPERTY = "xmpp-ep";
	public static final String AUTH_METHOD_PROPERTY = "auth-method";
	public static final String AUTH_TOKEN_PROPERTY = "auth-token";
	public static final String REFRESH_TOKEN_PROPERTY = "refresh-token";
	public static final String NETWORK_INTERFACE_PROPERTY = "network-interface";
	public static final String PUSH_INTERVAL_PROPERTY = "push-interval";

	/*	---------------------------------------------------------------------------------------
				Default values for the Device/Agent specific configurations listed above
	 	---------------------------------------------------------------------------------------	*/
	public static final String DEFAULT_DEVICE_OWNER = "admin";
	public static final String DEFAULT_DEVICE_ID = "1234567890";
	public static final String DEFAULT_IOT_SERVER_EP = "127.0.0.1:9763";
	public static final String DEFAULT_MQTT_BROKER_EP = "127.0.0.1:1883";
	public static final String DEFAULT_XMPP_SERVER_EP = "127.0.0.1:9061";
	public static final String DEFAULT_AUTH_METHOD = "token";
	public static final String DEFAULT_AUTH_TOKEN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321";
	public static final String DEFAULT_REFRESH_TOKEN = "1234567890ZYXWVUTSRQPONMKLJIHGFEDCBA";
	public static final String DEFAULT_NETWORK_INTERFACE = "lo0";
	public static final int DEFAULT_PUSH_INTERVAL = 15;

	/*	---------------------------------------------------------------------------------------
					Control Signal specific constants to match the request context
	 	---------------------------------------------------------------------------------------	*/
	public static final String BULB_CONTROL = "BULB";
	public static final String TEMPERATURE_CONTROL = "TEMP";
	public static final String HUMIDITY_CONTROL = "HUMID";
	public static final String CONTROL_ON = "ON";
	public static final String CONTROL_OFF = "OFF";
}
