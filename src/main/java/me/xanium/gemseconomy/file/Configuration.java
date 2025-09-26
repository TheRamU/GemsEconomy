/*
 * Copyright Xanium Development (c) 2013-2018. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Xanium Development. Distribution, reproduction, taking snippets or claiming
 * any contents as your own will break the terms of the license, and void any agreements with you, the third party.
 * Thank you.
 */

package me.xanium.gemseconomy.file;

import me.xanium.gemseconomy.GemsEconomy;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;

public class Configuration {

    private GemsEconomy plugin;

    public Configuration(GemsEconomy plugin) {
        this.plugin = plugin;
    }

    public void loadDefaultConfig() {

        FileConfiguration config = plugin.getConfig();

        config.options().header(plugin.getDescription().getName()
                + "\n"
                + "版本: " + plugin.getDescription().getVersion()
                + "\nGemsEconomy 主配置文件。"
                + "\n"
                + "开发者: " + plugin.getDescription().getAuthors()
                + "\n\n"
                + "您有三种有效的存储方法：yaml、mysql 或 sqlite。如果您选择 mysql，您需要在下面输入数据库凭据。"
                + "\n"
                + "下面的所有消息都是可配置的。");

        String path = "Messages.";

        config.addDefault("storage", "yaml");
        config.addDefault("debug", false);
        config.addDefault("vault", false);
        config.addDefault("transaction_log", true);
        config.addDefault("default_currency", "");

        config.addDefault("mysql.database", "minecraft");
        config.addDefault("mysql.tableprefix", "gemseconomy");
        config.addDefault("mysql.host", "localhost");
        config.addDefault("mysql.port", 3306);
        config.addDefault("mysql.username", "root");
        config.addDefault("mysql.password", "password");

      //  config.addDefault("sqlite.file", "database.sqlite");

        config.addDefault("cheque.material", Material.PAPER.toString());
        config.addDefault("cheque.name", "&a银行票据");
        config.addDefault("cheque.lore", Arrays.asList("&7价值：{value}。", "&7&o由 {player} 开具"));
        config.addDefault("cheque.console_name", "控制台");
        config.addDefault("cheque.enabled", true);

        config.addDefault(path + "prefix", "&2&lGemsEconomy> ");
        config.addDefault(path + "nopermission", "&7您没有权限执行此操作。");
        config.addDefault(path + "noconsole", "&7控制台无法执行此操作。");
        config.addDefault(path + "invalidamount", "&7无效的数量。");
        config.addDefault(path + "invalidpage", "&7无效的页码。");
        config.addDefault(path + "pay_yourself", "&7您不能给自己付款。");
        config.addDefault(path + "player_is_null", "&7指定的玩家不存在。");
        config.addDefault(path + "unknownCurrency", "&7未知货币。");
        config.addDefault(path + "unknownCommand", "&7未知子命令。");
        config.addDefault(path + "noDefaultCurrency", "&7没有默认货币。");
        config.addDefault(path + "currencyExists", "&7货币已存在。");
        config.addDefault(path + "accountMissing", "&7您的账户丢失。请重新登录服务器。");
        config.addDefault(path + "cannotReceiveMoney", "&a{player}&7 无法接收资金。");
        config.addDefault(path + "insufficientFunds", "&7您没有足够的 {currencycolor}{currency}&7！");
        config.addDefault(path + "targetInsufficientFunds", "&e{target} &7没有足够的 {currencycolor}{currency}&7！");
        config.addDefault(path + "paid", "&7您收到了来自 &a{player}&7 的 {currencycolor}{amount}&7。");
        config.addDefault(path + "payer", "&7您向 &a{player}&7 支付了 {currencycolor}{amount}&7。");
        config.addDefault(path + "payNoPermission", "&7您没有权限支付 {currencycolor}{currency}&7。");
        config.addDefault(path + "currencyNotPayable", "{currencycolor}{currency} &7不可支付。");
        config.addDefault(path + "add", "&7您给予了 &a{player}&7: {currencycolor}{amount}。 ");
        config.addDefault(path + "take", "&7您从 &a{player}&7 那里取走了 {currencycolor}{amount}&7。");
        config.addDefault(path + "set", "&7您将 &a{player}&7 的余额设置为 {currencycolor}{amount}&7。");

        config.addDefault(path + "exchange_rate_set", "&7已将 {currencycolor}{currency} &7的汇率设置为 &a{amount}&7。");
        config.addDefault(path + "exchange_success_custom_other", "&7成功为玩家 {player}&7 将 {currencycolor}({currEx}) &7兑换为 {currencycolor2}{receivedCurr}&7。");
        config.addDefault(path + "exchange_success_custom", "&7成功将 {currencycolor}({currEx}) &7兑换为 {currencycolor2}{receivedCurr}&7。");
        config.addDefault(path + "exchange_success", "&7成功将 {currencycolor}{ex_curr} &7兑换为等值的 {currencycolor2}{re_curr}&7。");
        config.addDefault(path + "exchange_command.no_perms.preset", "&7您没有权限使用预设汇率兑换货币。");
        config.addDefault(path + "exchange_command.no_perms.custom", "&7您没有权限使用自定义汇率兑换货币。");

        config.addDefault(path + "balance.current", "&a{player}&7 的余额为：{currencycolor}{balance}");
        config.addDefault(path + "balance.multiple", "&a{player}&7 的余额：");
        config.addDefault(path + "balance.list", "&a&l>> {currencycolor}{format}");
        config.addDefault(path + "balance.none", "&c{player}&7 没有余额可显示。");

        config.addDefault(path + "balance_top.balance", "&a&l-> {number}. {currencycolor}{player} &7- {currencycolor}{balance}");
        config.addDefault(path + "balance_top.header", "&f----- {currencycolor} {currencyplural} 余额排行榜 &7(第 {page} 页)&f -----");
        config.addDefault(path + "balance_top.empty", "&7没有账户可显示。");
        config.addDefault(path + "balance_top.next", "{currencycolor}/gbaltop {currencyplural} {page} &7查看更多。");
        config.addDefault(path + "balance_top.nosupport", "&a{storage} &7不支持 /baltop 命令。");

        config.addDefault(path + "cheque.success", "&7支票开具成功。");
        config.addDefault(path + "cheque.redeemed", "&7支票已兑现。");
        config.addDefault(path + "cheque.invalid", "&7这不是一张有效的支票。");

        config.addDefault(path + "help.eco_command", Arrays.asList(
                "{prefix}&e&l经济帮助",
                "&2&l>> &a/eco give <用户> <数量> [货币] &8- &7给予玩家一定数量的货币。",
                "&2&l>> &a/eco take <用户> <数量> [货币] &8- &7从玩家那里取走一定数量的货币。",
                "&2&l>> &a/eco set <用户> <数量> [货币] &8- &7设置玩家的货币数量。"));

        config.addDefault(path + "help.exchange_command", Arrays.asList(
                "{prefix}&b&l兑换帮助",
                "&2&l>> &a/exchange <账户> <要兑换的货币> <数量> <要接收的货币> <数量> &8- &7为账户使用自定义汇率在货币之间进行兑换。",
                "&2&l>> &a/exchange <要兑换的货币> <数量> <要接收的货币> <数量> &8- &7使用自定义汇率在货币之间进行兑换。",
                "&2&l>> &a/exchange <要兑换的货币> <数量> <要接收的货币> &8- &7使用预设汇率进行兑换。"));

        config.addDefault(path + "usage.pay_command", "&2&l>> &a/pay <用户> <数量> [货币] &8- &7向指定用户支付指定数量。");
        config.addDefault(path + "usage.give_command", "&2&l>> &a/eco give <用户> <数量> [货币] &8- &7给予玩家一定数量的货币。");
        config.addDefault(path + "usage.take_command", "&2&l>> &a/eco take <用户> <数量> [货币] &8- &7从玩家那里取走一定数量的货币。");
        config.addDefault(path + "usage.set_command", "&2&l>> &a/eco set <用户> <数量> [货币] &8- &7设置玩家的货币数量。");

        config.addDefault(path + "help.cheque_command", Arrays.asList("{prefix}&e&l支票帮助",
                "&2&l>> &a/cheque write <数量> [货币] &8- &7开具指定数量和货币的支票。",
                "&2&l>> &a/cheque redeem &8- &7兑现支票。"));

        config.addDefault(path + "help.currency_command", Arrays.asList("{prefix}&e&l货币帮助",
                "&2&l>> &a/currency create <单数名称> <复数名称> &8- &7创建货币。",
                "&2&l>> &a/currency delete <复数名称> &8- &7删除货币。",
                "&2&l>> &a/currency convert <方法> &8- &7转换存储方法。警告：请先备份并确保要切换到的存储是空的！",
                "&2&l>> &a/currency backend <方法> &8- &7切换后端。这不会转换数据。",
                "&2&l>> &a/currency view <复数名称> &8- &7查看货币信息。",
                "&2&l>> &a/currency list &8- &7货币列表。",
                "&2&l>> &a/currency symbol <复数名称> <字符|删除> &8- &7为货币选择符号或删除符号。",
                "&2&l>> &a/currency color <复数名称> <颜色> &8- &7为货币选择颜色。",
                "&2&l>> &a/currency colorlist &8- &7颜色列表。",
                "&2&l>> &a/currency decimals <复数名称> &8- &7为货币启用小数。",
                "&2&l>> &a/currency payable <复数名称> &8- &7设置货币是否可支付。",
                "&2&l>> &a/currency default <复数名称> &8- &7设置为默认货币。",
                "&2&l>> &a/currency startbal <复数名称> <数量> &8- &7设置货币的起始余额。",
                "&2&l>> &a/currency setrate <复数名称> <数量> &8- &7设置货币的汇率。"));

        config.addDefault(path + "usage.currency_create", "&2&l>> &a/currency create <单数名称> <复数名称> &8- &7创建货币。");
        config.addDefault(path + "usage.currency_delete", "&2&l>> &a/currency delete <复数名称> &8- &7删除货币。");
        config.addDefault(path + "usage.currency_convert", "&2&l>> &a/currency convert <方法> &8- &7转换存储方法。警告：请先备份并确保要切换到的存储是空的！");
        config.addDefault(path + "usage.currency_backend", "&2&l>> &a/currency backend <方法> &8- &7切换后端。这不会转换数据。");
        config.addDefault(path + "usage.currency_view", "&2&l>> &a/currency view <复数名称> &8- &7查看货币信息。");
        config.addDefault(path + "usage.currency_list", "&2&l>> &a/currency list &8- &7货币列表。");
        config.addDefault(path + "usage.currency_symbol", "&2&l>> &a/currency symbol <复数名称> <字符|删除> &8- &7为货币选择符号或删除符号。");
        config.addDefault(path + "usage.currency_color", "&2&l>> &a/currency color <复数名称> <颜色> &8- &7为货币选择颜色。");
        config.addDefault(path + "usage.currency_colorlist", "&2&l>> &a/currency colorlist &8- &7颜色列表。");
        config.addDefault(path + "usage.currency_payable", "&2&l>> &a/currency payable <复数名称> &8- &7设置货币是否可支付。");
        config.addDefault(path + "usage.currency_default", "&2&l>> &a/currency default <复数名称> &8- &7设置为默认货币。");
        config.addDefault(path + "usage.currency_decimals", "&2&l>> &a/currency decimals <复数名称> &8- &7为货币启用小数。");
        config.addDefault(path + "usage.currency_startbal", "&2&l>> &a/currency startbal <复数名称> <数量> &8- &7设置货币的起始余额。");
        config.addDefault(path + "usage.currency_setrate", "&2&l>> &a/currency setrate <复数名称> <数量> &8- &7设置货币的汇率。");

        config.options().copyDefaults(true);
        plugin.saveConfig();
        plugin.reloadConfig();
    }

}
