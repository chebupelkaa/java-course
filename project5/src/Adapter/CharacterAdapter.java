package Adapter;

public class CharacterAdapter implements Player {
    private final GameCharacter legacyCharacter;

    public CharacterAdapter(final GameCharacter legacyCharacter) {
        this.legacyCharacter = legacyCharacter;
    }

    @Override
    public void attack() {
        legacyCharacter.performAction();
    }

    @Override
    public void move() {
        legacyCharacter.changePosition();
    }

    @Override
    public String getStatus() {
        return legacyCharacter.getCharacterInfo();
    }
}