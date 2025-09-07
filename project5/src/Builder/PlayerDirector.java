package Builder;

public class PlayerDirector {
    public Player createHeroicWarrior(final PlayerBuilder builder, final String name) {
        return builder.setName(name).setLevel(5).build();
    }

    public Player createArchmage(final PlayerBuilder builder, final String name) {
        return builder.setName(name).setLevel(8).build();
    }

    public Player createNewbie(final PlayerBuilder builder, final String name) {
        return builder.setName(name).setLevel(1).build();
    }
}