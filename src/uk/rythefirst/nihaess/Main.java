package uk.rythefirst.nihaess;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import uk.rythefirst.nihaess.bounties.BHolder;
import uk.rythefirst.nihaess.bounties.DataHandler;
import uk.rythefirst.nihaess.commands.BanSword;
import uk.rythefirst.nihaess.commands.BountiesSave;
import uk.rythefirst.nihaess.commands.BountyCMD;
import uk.rythefirst.nihaess.commands.Cast;
import uk.rythefirst.nihaess.commands.EggDeed;
import uk.rythefirst.nihaess.commands.Help;
import uk.rythefirst.nihaess.commands.Info;
import uk.rythefirst.nihaess.commands.Mding;
import uk.rythefirst.nihaess.commands.ModHelp;
import uk.rythefirst.nihaess.commands.Removebounty;
import uk.rythefirst.nihaess.commands.Report;
import uk.rythefirst.nihaess.commands.Reservedslots;
import uk.rythefirst.nihaess.commands.SellXP;
import uk.rythefirst.nihaess.commands.SetBounty;
import uk.rythefirst.nihaess.commands.ShopFix;
import uk.rythefirst.nihaess.commands.ShopInfo;
import uk.rythefirst.nihaess.commands.StreamInfo;
import uk.rythefirst.nihaess.commands.StreamLive;
import uk.rythefirst.nihaess.commands.Streamdmg;
import uk.rythefirst.nihaess.commands.Togglemention;
import uk.rythefirst.nihaess.commands.Twitch;
import uk.rythefirst.nihaess.commands.Webmap;
import uk.rythefirst.nihaess.commands.Website;
import uk.rythefirst.nihaess.commands.dummys;
import uk.rythefirst.nihaess.events.ChatEvent;
//import uk.rythefirst.nihaess.crafting.Tools;
import uk.rythefirst.nihaess.events.EntityDamageEntity;
import uk.rythefirst.nihaess.events.InventoryClick;
import uk.rythefirst.nihaess.events.Leave;
import uk.rythefirst.nihaess.events.MobDeath;
import uk.rythefirst.nihaess.events.MoveEvent;
import uk.rythefirst.nihaess.events.PlayerDeath;
import uk.rythefirst.nihaess.events.PlayerInteract;
import uk.rythefirst.nihaess.events.Plugins;
import uk.rythefirst.nihaess.events.onJoin;
import uk.rythefirst.nihaess.games.ChatWordGame;
import uk.rythefirst.nihaess.twitch.TwitchAPI;
import uk.rythefirst.nihaess.util.MentionHandler;
import uk.rythefirst.nihaess.util.MessageFilter;

public class Main extends JavaPlugin {

	private static Economy econ;
	private static Permission perms;
	private static Chat chat;
	private static TwitchAPI tapi;
	private static ChatWordGame cwg;
	private Logger log;
	private MentionHandler mhandler;

	public static MessageFilter mfilter = new MessageFilter();

	private static Integer resslots;

	@Override
	public void onEnable() {

		this.saveDefaultConfig();

		instance = this;

		tapi = new TwitchAPI();

		mhandler = new MentionHandler();

		cwg = new ChatWordGame();

		log = Bukkit.getLogger();

		// Registering Events
		Bukkit.getPluginManager().registerEvents(new MobDeath(), this);
		Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamageEntity(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
		Bukkit.getPluginManager().registerEvents(new Plugins(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
		Bukkit.getPluginManager().registerEvents(new onJoin(), this);
		Bukkit.getPluginManager().registerEvents(new Leave(), this);
		Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);

		log.log(Level.INFO, "[NESS] Registered Events!");

		// Registering Commands
		this.getCommand("help").setExecutor(new Help());
		this.getCommand("pinfo").setExecutor(new Info());
		this.getCommand("modhelp").setExecutor(new ModHelp());
		this.getCommand("shopinfo").setExecutor(new ShopInfo());
		this.getCommand("dummys").setExecutor(new dummys());
		this.getCommand("eggdeed").setExecutor(new EggDeed());
		this.getCommand("live").setExecutor(new StreamLive());
		this.getCommand("sinfo").setExecutor(new StreamInfo());
		this.getCommand("bounties").setExecutor(new BountyCMD());
		this.getCommand("twitch").setExecutor(new Twitch());
		this.getCommand("cast").setExecutor(new Cast());
		this.getCommand("setbounty").setExecutor(new SetBounty());
		this.getCommand("savebounties").setExecutor(new BountiesSave());
		this.getCommand("webmap").setExecutor(new Webmap());
		this.getCommand("website").setExecutor(new Website());
		this.getCommand("togglemention").setExecutor(new Togglemention());
		this.getCommand("removebounty").setExecutor(new Removebounty());
		this.getCommand("streamdmg").setExecutor(new Streamdmg());
		this.getCommand("sellxp").setExecutor(new SellXP());
		this.getCommand("reservedslots").setExecutor(new Reservedslots());
		this.getCommand("mding").setExecutor(new Mding());
		this.getCommand("shopfix").setExecutor(new ShopFix());
		this.getCommand("bansword").setExecutor(new BanSword());
		this.getCommand("report").setExecutor(new Report());

		log.log(Level.INFO, "[NESS] Registered Commands!");

		// Register Scheduled Tasks
		tapi.StartWatcher();
		log.log(Level.INFO, "[NESS] Registered Taks!");

		mhandler.loadDisables();

		// Registering Crafting Recipes
		// Bukkit.addRecipe(Tools.emeraldSword());

		resslots = this.getConfig().getInt("reservedslots");

		// Load Bounties
		DataHandler.loadBounties();
		BHolder.loadInv();

		// Setup Vault
		if (!setupEconomy()) {
			this.getLogger().severe("Disabled due to no Vault dependency found!");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		this.setupPermissions();
		this.setupChat();

		cwg.runGame();
	}

	@Override
	public void onDisable() {

		mhandler.saveDisables();
		DataHandler.saveBounties();
		Bukkit.getLogger().log(Level.INFO, "Bounties saved.");

	}

	public static TwitchAPI getTAPI() {

		return tapi;

	}

	public static int getResSlots() {
		return resslots;
	}

	public static ChatWordGame getCwg() {
		return cwg;
	}

	public static Plugin instance;

	private boolean setupEconomy() {
		if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
			return false;
		}

		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	public static Economy getEconomy() {
		return econ;
	}

	public static Permission getPermissions() {
		return perms;
	}

	public static Chat getChat() {
		return chat;
	}

}
