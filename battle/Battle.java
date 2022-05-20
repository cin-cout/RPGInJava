package battle;
import player.*;
import monster.*;

public class Battle {

    private Charactor[] ActionList;
    public Battle(NovicePlayer[] p, BaseMonster[] m, int nplay, int nmon) {

        ActionList = new Charactor[nplay + nmon];

        for (int i = 0; i < nplay; i++) {
            ActionList[i].type = 'p';
            ActionList[i].alive = 1;
            ActionList[i].instance = p[i];
        }

        for (int j = nplay; j < (nmon + nplay); j++) {
            ActionList[j].type = 'm';
            ActionList[j].alive = 1;
            ActionList[j].instance = m[j-nplay];
        }

        int a;
        int b;
        int gexp = 0;
        int gmoney = 0;
        boolean wp;
        boolean wm;
        boolean conti;
        NovicePlayer tmp_player;
        BaseMonster tmp_monster;

        do {

            for (int i = 0; i < (nmon + nplay); i++) {
    
                int chooap = 9999999;//choose attack player
                //顯示
                if (ActionList[i].alive == 1) {
                    /*
                    line 40 41 just for color changing don't mind

                    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
                        FOREGROUND_GREEN);
                    cout << "----------目前血量狀態----------" << endl;
                    */
                    for (int i = 0; i < (nmon + nplay); i++) {
                        if (ActionList[i].type == 'p') {
                            //SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED);
                            //if (i == 0) { cout << "◆ Player ◆" << endl; }
                            tmp_player = (NovicePlayer)(ActionList[i].instance);
                            //cout << (*tmp_player).getName() << ": ";
                            a = tmp_player.getHP();
                            b = tmp_player.getMaxHP();
                            /*
                            for (int j = 0; j < (a * 10 / b); j++) {
                                cout << "■";
                            }
                            cout << endl << "→HP:" << a << "/" << b
                                << " MP:" << (*tmp_player).getMP() << "/" << (*tmp_player).getMaxMP()
                                << " Attack:" << (*tmp_player).getAttack() << " Defense:" << (*tmp_player).getDefense()
                                << " Lv:" << (*tmp_player).getLevel() << " Exp:" << (*tmp_player).getExp() << "/" << (*tmp_player).getLvupExp()
                                << " Money:" << (*tmp_player).getMoney();
                            cout << endl;
                            */
                        }
                        else if (ActionList[i].type == 'm') {
                            //SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_BLUE);
                            //if (i == nplay) { cout << endl << "◆ Monster ◆" << endl; }
                            tmp_monster = (BaseMonster)(ActionList[i].instance);
                            a = tmp_monster.getHP();
                            b = tmp_monster.max_hp;
                            /*
                            cout << (*tmp_monster).name << ": ";
                            for (int j = 0; j < (a * 10 / b); j++) {
                                cout << "■";
                            }
                            cout << endl << "→HP:" << a << "/" << b
                                << " MP:" << (*tmp_monster).getMP() << "/" << (*tmp_monster).max_mp
                                << " Attack:" << (*tmp_monster).attack << " Defense:" << (*tmp_monster).defense
                                << " Exp:" << (*tmp_monster).exp
                                << " Money:" << (*tmp_monster).money;
                            cout << endl;
                            */
                        }
                    }
                    /*
                    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
                        FOREGROUND_GREEN);
                    cout << "--------------------------------" << endl;
                    */
                }
    
                if (ActionList[i].type == 'p' && ActionList[i].alive == 1) {
                    tmp_player = (NovicePlayer)(ActionList[i].instance);
                    /*

                    this part need to trace choose who you want to attack

                    cout << "現在是" << (*tmp_player).getName() << "的攻擊回合" << endl;
                    cout << endl << "想攻擊幾號怪獸" << endl;
                    
                    do {
                        do {
                            cout << "注意攻擊的怪獸無法不存在或是已死亡: ";
                            cin >> a;
                        } while (0 > a || a > nmon);
                        
                        tmp_monster = static_cast<BaseMonster*>(ActionList[nplay + a-1].instance);
                    } while (ActionList[nplay + a - 1].alive == 0);
                    */

                    /*
                    cout << endl;
                    cout << (*tmp_player).getName() << "選擇攻擊" << (*tmp_monster).name << endl;
                    */
                    if ((tmp_player.getAttack() - tmp_monster.defense) <= 0) { b = 0;}
                    else { b = (tmp_player.getAttack() - tmp_monster.defense); }
                    //cout << (*tmp_monster).name << "受到" << b << "傷害" << endl;
                    tmp_monster.setHP(tmp_monster.getHP()- b);
                    
                    if (tmp_monster.getHP() == 0) {
                        // be care full that a cin have been comment
                        ActionList[nplay + a - 1].alive = 0;
                        gexp += tmp_monster.exp;
                        gmoney += tmp_monster.money;
                    }
                    /*
                    cout << endl;
                    system("pause");
                    */
                }
    
                else if (ActionList[i].type == 'm' && ActionList[i].alive == 1) {
                    tmp_monster = (BaseMonster)ActionList[i].instance;
                    //cout << "現在是" << (*tmp_monster).name << "的攻擊回合" << endl;
    
                    for (int j = 0; j < nplay; j++) {
                        tmp_player = (NovicePlayer)ActionList[j].instance;
                        if (chooap > tmp_player.getHP() && ActionList[j].alive == 1) {
                            chooap = tmp_player.getHP();
                            a = j;
                        }
                    }
    
                    tmp_player = (NovicePlayer) ActionList[a].instance;
                    
                    /*
                    cout << endl;
                    cout << (*tmp_monster).name << "選擇攻擊" << (*tmp_player).getName() << endl;
                    */
                    if ((tmp_monster.attack - tmp_player.getDefense()) <= 0) { b = 0; }
                    else { b = (tmp_monster.attack - tmp_player.getDefense()); }
    
                    //cout << (*tmp_player).getName() << "受到" << b << "傷害" << endl;
                    tmp_player.setHP(tmp_player.getHP() - b);
    
                    if (tmp_player.getHP() == 0) {
                        ActionList[a].alive = 0;
                    }
                    /*
                    cout << endl;
                    system("pause");
                    */
                }
                //system("cls");
            
            //判斷輸贏
                for (int j = 0; j < nplay; j++) {
                    if (ActionList[j].alive == 1) {
                        wp = true;
                        break;
                    }
                    else { wp = false; }
                }
    
                for (int j = nplay; j < (nplay+nmon); j++) {
                    if (ActionList[j].alive == 1) {
                        wm = true;
                        break;
                    }
                    else { wm = false; }
                }
    
                if (wp == false || wm == false) {
                    conti = true;
                    break;
                }
                else { conti = true; }
            }
    
        } while (conti);
    
        if (wm == false) { 
            /*
            cout << "Player win" << endl;
            cout << "每人獲得" << gexp << "經驗" << endl;
            cout << "每人獲得" << gmoney << "金錢";
            */
            for (int i = 0; i < nplay; i++) {
                tmp_player = p[i];
                tmp_player.setExp(tmp_player.getExp() + gexp);
                tmp_player.setMoney(tmp_player.getMoney() + gmoney);
                /*
                cout << endl;
                cout << endl;
                */
                if (tmp_player.getExp() > tmp_player.getLvupExp()) {
                    a = (int) Math.pow(2, Math.log10(tmp_player.getExp()));
                    tmp_player.setLevel(a);
                    //cout << (*tmp_player).getName() << "升級了,目前" << (*tmp_player).getLevel() << "等" << endl;
                }
    
                //else { cout << (*tmp_player).getName() << "等級不變,目前" << (*tmp_player).getLevel() << "等" << endl; }
                /*
                cout << (*tmp_player).getName() << ": Lv:" << (*tmp_player).getLevel() << 
                    " Exp:" << (*tmp_player).getExp() << "/" << (*tmp_player).getLvupExp()<< 
                    " Money:" << (*tmp_player).getMoney() <<endl;
                */
            }
    
        }
    
        else if (wp == false) { 
            /*
            cout << "Monster win" << endl;
            cout << "Game Over";
            */
        }

    }
}
