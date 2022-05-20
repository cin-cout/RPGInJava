package player;

public class KnightPlayer extends NovicePlayer{
    

    public KnightPlayer(int l, String n) 
    {
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
        attack = 40 + 10 * getLevel();
        defense = 20 + 12 * getLevel();
        max_hp = 150 + 25 * getLevel();
        max_mp = 70 + 10 * getLevel();
        lvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        lastlvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }

    public void specialSkill() {
        if (getMP() - 5 * getLevel() > 0) {
            setMP(getMP() - 5 * getLevel());
            //undefine very well
        }
    }
}
