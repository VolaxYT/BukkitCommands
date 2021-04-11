package fr.volax.heal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(player.hasPermission("heal.use")){
                if(args.length == 0){
                    player.setFoodLevel(20);
                    player.setHealth(20);
                    player.sendMessage("§aVous venez de vous heal !");
                    return false;
                }else if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        target.setFoodLevel(20);
                        target.setHealth(20);
                        target.sendMessage("§aVous venez d'être heal !");
                        player.sendMessage("§aVous venez de heal " + args[0] + " !");
                        return false;
                    }else{
                        player.sendMessage("§cLe joueur n'existe pas !");
                        return false;
                    }
                }else{
                    sender.sendMessage("§7/heal <joueur>");
                    return false;
                }
            }else{
                player.sendMessage("§cVous n'avez pas la permission d'executer cette commande !");
                return false;
            }
        }else{
            sender.sendMessage("§cVous devez être un joueur pour executer cette commande !");
            return false;
        }
    }
}
