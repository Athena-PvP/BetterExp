package com.kuriji.betterexp.event.block;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.kuriji.betterexp.BetterExp;

public class BlockBreak implements Listener {
	
	
	private BetterExp plugin;	
	int grass;
	int dirt;
	int wood;
	int sand;
	
	public BlockBreak(BetterExp pl){
		
		plugin = pl;
	 
		grass = plugin.getConfig().getInt("Grass");
		dirt = plugin.getConfig().getInt("Dirt");
		wood = plugin.getConfig().getInt("Wood");
		sand = plugin.getConfig().getInt("Sand");
	}

	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		Player player = event.getPlayer();
		
		Block block = event.getBlock();
		Material material = block.getType();
		
		if(material == Material.GRASS) {
			player.giveExp(grass);
		}
		else if(material == Material.DIRT){
			player.giveExp(dirt);
		}
		else if(material == Material.WOOD){
			player.giveExp(wood);
		}
		else if(material == Material.SAND){
			player.giveExp(sand);
		}		
	}
}
