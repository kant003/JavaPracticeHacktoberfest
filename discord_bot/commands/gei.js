const { SlashCommandBuilder } = require('discord.js');

module.exports = {
	data: new SlashCommandBuilder()
		.setName('gei')
		.setDescription('dice miguelo es gei'),
	async execute(interaction) {
		await interaction.reply('el miguelter');
	},
};