package fr.utc.nf28.moka.util;

import java.util.UUID;

import fr.utc.nf28.moka.agent.IAndroidAgent;
import jade.core.MicroRuntime;
import jade.wrapper.ControllerException;

public class JadeUtils {
	/**
	 * Agent name for AndroidAgent. Unique name based on UUID
	 */
	public static final String ANDROID_AGENT_NICKNAME = "AndroidAgent_" + UUID.randomUUID().toString();
	/**
	 * default type for Jade skill registering
	 */
	public static final String JADE_SKILL_TYPE_DEFAULT = "MokaDefaultSkillType";
	/**
	 * name for Jade skill registering of AndroidAgent
	 */
	public static final String JADE_SKILL_NAME_ANDROID = "AndroidAgentSkillName";
	/**
	 * name for Jade skill registering of ConnectionAgent
	 */
	public static final String JADE_SKILL_NAME_CONNECTION = "ConnectionAgentSkillName";
	/**
	 * name for Jade skill registering of CreationAgent
	 */
	public static final String JADE_SKILL_NAME_CREATION = "CreationAgentSkillName";
	private static final IAndroidAgent sDummyAndroidAgentInterface = new IAndroidAgent() {
		@Override
		public void connectPlatform(String firstName, String lastName, String ip) {
		}

		@Override
		public void createItem() {
		}

		@Override
		public void lockItem() {
		}

		@Override
		public void editItem() {
		}
	};

	/**
	 * use to call method of AndroidAgent from Activity
	 *
	 * @return interface reference of AndroidAgent running on device
	 */
	public static IAndroidAgent getAndroidAgentInterface() {
		try {
			return MicroRuntime.getAgent(ANDROID_AGENT_NICKNAME).getO2AInterface(IAndroidAgent.class);
		} catch (ControllerException e) {
			e.printStackTrace();
			return sDummyAndroidAgentInterface;
		}
	}

	//connection transaction
	public static final String TRANSACTION_TYPE_CONNECTION = "connection";

	//addItem transaction
	public static final String TRANSACTION_TYPE_ADD_ITEM = "addItem";
}
