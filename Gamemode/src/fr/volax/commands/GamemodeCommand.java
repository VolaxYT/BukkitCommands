package fr.volax.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0){
            helpMessage(sender);
            return false;
        }else if(args.length == 1){
            if(args[0].equalsIgnoreCase("CREATIVE") || args[0].equalsIgnoreCase("CREATIF") ||args[0].equalsIgnoreCase("1")){
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    if(player.hasPermission("youtube.gamemode")){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("§eVous venez de passer en gamemode §6Créatif §e!");
                        return false;
                    }else{
                        permissionMessage(player);
                        return false;
                    }
                }else{
                    errorMessage(sender);
                    return false;
                }
            }
            if(args[0].equalsIgnoreCase("SURVIVAL") || args[0].equalsIgnoreCase("SURVIE") ||args[0].equalsIgnoreCase("0")){
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    if(player.hasPermission("youtube.gamemode")){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage("§eVous venez de passer en gamemode §6Survie §e!");
                        return false;
                    }else{
                        permissionMessage(player);
                        return false;
                    }
                }else{
                    errorMessage(sender);
                    return false;
                }
            }
            if(args[0].equalsIgnoreCase("ADVENTURE") || args[0].equalsIgnoreCase("AVENTURE") ||args[0].equalsIgnoreCase("2")){
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    if(player.hasPermission("youtube.gamemode")){
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage("§eVous venez de passer en gamemode §6Aventure §e!");
                        return false;
                    }else{
                        permissionMessage(player);
                        return false;
                    }
                }else{
                    errorMessage(sender);
                    return false;
                }
            }
            if(args[0].equalsIgnoreCase("SPECTATOR") || args[0].equalsIgnoreCase("SPECTATEUR") ||args[0].equalsIgnoreCase("3")){
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    if(player.hasPermission("youtube.gamemode")){
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("§eVous venez de passer en gamemode §6Spectateur §e!");
                        return false;
                    }else{
                        permissionMessage(player);
                        return false;
                    }
                }else{
                    errorMessage(sender);
                    return false;
                }
            }else{
                helpMessage(sender);
                return false;
            }
        }else if(args.length == 2){
            if(args[0].equalsIgnoreCase("CREATIVE") || args[0].equalsIgnoreCase("CREATIF") ||args[0].equalsIgnoreCase("1")){
                if(sender instanceof Player){
                    if(!sender.hasPermission("youtube.gamemode")){
                        errorMessage(sender);
                        return false;
                    }
                }

                Player target = Bukkit.getPlayer(args[1]);
                if(target == null){
                    sender.sendMessage("§cCe joueur n'est pas en ligne !");
                    return false;
                }
                target.setGameMode(GameMode.CREATIVE);
                sender.sendMessage("§eVous venez de passer §6" + target.getName() + " §een §6Créatif §e!");
                return false;
            }
            if(args[0].equalsIgnoreCase("SURVIVAL") || args[0].equalsIgnoreCase("SURVIE") ||args[0].equalsIgnoreCase("0")){
                if(sender instanceof Player){
                    if(!sender.hasPermission("youtube.gamemode")){
                        errorMessage(sender);
                        return false;
                    }
                }

                Player target = Bukkit.getPlayer(args[1]);
                if(target == null){
                    sender.sendMessage("§cCe joueur n'est pas en ligne !");
                    return false;
                }
                target.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage("§eVous venez de passer §6" + target.getName() + " §een §6Survie §e!");
                return false;
            }
            if(args[0].equalsIgnoreCase("ADVENTURE") || args[0].equalsIgnoreCase("AVENTURE") ||args[0].equalsIgnoreCase("2")){
                if(sender instanceof Player){
                    if(!sender.hasPermission("youtube.gamemode")){
                        errorMessage(sender);
                        return false;
                    }
                }

                Player target = Bukkit.getPlayer(args[1]);
                if(target == null){
                    sender.sendMessage("§cCe joueur n'est pas en ligne !");
                    return false;
                }
                target.setGameMode(GameMode.ADVENTURE);
                sender.sendMessage("§eVous venez de passer §6" + target.getName() + " §een §6Aventure §e!");
                return false;
            }
            if(args[0].equalsIgnoreCase("SPECTATOR") || args[0].equalsIgnoreCase("SPECTATEUR") ||args[0].equalsIgnoreCase("3")){
                if(sender instanceof Player){
                    if(!sender.hasPermission("youtube.gamemode")){
                        errorMessage(sender);
                        return false;
                    }
                }

                Player target = Bukkit.getPlayer(args[1]);
                if(target == null){
                    sender.sendMessage("§cCe joueur n'est pas en ligne !");
                    return false;
                }
                target.setGameMode(GameMode.SPECTATOR);
                sender.sendMessage("§eVous venez de passer §6" + target.getName() + " §een §6Spectateur §e!");
                return false;
            }else{
                helpMessage(sender);
                return false;
            }
        }else{
            helpMessage(sender);
            return false;
        }
    }

    private void helpMessage(CommandSender player){
        player.sendMessage("§e/gm <CREATIVE|SURVIVAL|ADVENTURE|SPECTATOR> <PLAYER>");
    }

    private void errorMessage(CommandSender player){
        player.sendMessage("§cVous devez être un joueur pour executer cette commande !");
    }

    private void permissionMessage(CommandSender player){
        player.sendMessage("§cVous n'avez pas la permission d'executer cette commande !");
    }
}
