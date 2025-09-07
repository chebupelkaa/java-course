package Builder;

public interface PlayerBuilder {
    PlayerBuilder setName(final String name);

    PlayerBuilder setLevel(final int level);

    Player build();
}
