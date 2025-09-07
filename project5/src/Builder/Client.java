package Builder;

public class Client {
    public static void main(String[] args) {
        final PlayerDirector director = new PlayerDirector();
        final PlayerBuilder warriorBuilder = new WarriorBuilder();
        final PlayerBuilder mageBuilder = new MageBuilder();

        final Player warrior1 = warriorBuilder.setName("Atrox").setLevel(3).build();
        final Player warrior2 = director.createHeroicWarrior(warriorBuilder, "Olaf");

        final Player mage1 = mageBuilder.setName("Ari").setLevel(4).build();
        final Player mage2 = director.createArchmage(mageBuilder, "Lux");

        final Player newbieWarrior = director.createNewbie(warriorBuilder, "Garen");
        final Player newbieMage = director.createNewbie(mageBuilder, "Zoi");

        warrior1.displayInfo();
        warrior2.displayInfo();
        mage1.displayInfo();
        mage2.displayInfo();
        newbieWarrior.displayInfo();
        newbieMage.displayInfo();
    }
}
