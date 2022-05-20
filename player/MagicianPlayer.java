package player;

public class MagicianPlayer extends NovicePlayer{

    public MagicianPlayer(int l, String n){
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
        attack = 30 + 8 * getLevel();
        defense = 20 + 7 * getLevel();
        max_hp = 120 + 15 * getLevel();
        max_mp = 100 + 15 * getLevel();
        lvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        lastlvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }
    
    public void specialSkill() {
        if (getMP() - 5 * getLevel() > 0) {
            setMP(getMP() - 5 * getLevel());
            //undefine the skill
        }
        
    }
}
