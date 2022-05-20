package player;

public class OrcPlayer extends NovicePlayer{

    public OrcPlayer(int l,String n){
        super();
        setLevel(l);
        setName(n);
        setHP(getMaxHP());
        setMP(getMaxMP());
        setExp(lastlvup_exp);
        setMoney(0);
    }
    
    
    public void setLevel(int l) {
        level = (1 <= l) ? l : 1;
        attack = 50 + 12 * getLevel();
        defense = 30 + 10 * getLevel();
        max_hp = 200 + 20 * getLevel();
        max_mp = 50 + 5 * getLevel();
        lvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        lastlvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }
    
    public void specialSkill() {
        if (getMP() - 5 * getLevel() > 0) {
            setHP(getHP() + 10 * getLevel());
            setMP(getMP() - 5 * getLevel());
            //well define
        }
    }

}
