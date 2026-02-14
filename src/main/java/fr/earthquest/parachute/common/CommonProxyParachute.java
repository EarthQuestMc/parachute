package fr.earthquest.parachute.common;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommonProxyParachute {
	
	private static final Logger logger = FMLLog.getLogger();

	public static Configuration config;

	public static Map<String, Integer> blockList = new LinkedHashMap<String, Integer>();
	public static Map<String, Integer> itemList = new LinkedHashMap<String, Integer>();

	public void registerRenderer()
	{
	}
	
	public void registerHandlers()
	{
		
	}

	public int addArmor(String armorName)
	{
		return 0;
	}
	
	public void print(String s)
	{
		logger.info(s);
	}

	public void initConfig() {
		CommonProxyParachute.config.load();

		//ID configuration ( Minecraft limit )
		//-Block: 422 > id < 2256 - 2267 > id < 4096
		//-Item: 4096 > id < 32768
		// /!\ Add new block or item to the bottom of their list /!\

		int idBlock = 450; //Start id
		for(Map.Entry<String, Integer> block : blockList.entrySet()) {
			CommonProxyParachute.blockList.put(block.getKey(), CommonProxyParachute.config.get("id.blocks", block.getKey(), idBlock).getInt());
			idBlock++;
		}

		CommonProxyParachute.itemList.put("Parachute", 0);
		CommonProxyParachute.itemList.put("Ripcord", 0);
		CommonProxyParachute.itemList.put("AutoActivationDevice", 0);
		CommonProxyParachute.itemList.put("HopAndPop", 0);

		List<Integer> idList = new ArrayList();

		int idItem = 9000; //Start id
		for(Map.Entry<String, Integer> item : itemList.entrySet()) {
			item.setValue(CommonProxyParachute.config.get("id.items", item.getKey(), idItem).getInt());
			idList.add(idItem);
			idItem++;
			while(idList.contains(idItem)) {
				idItem++;
			}
		}

		CommonProxyParachute.config.save();
	}
}
