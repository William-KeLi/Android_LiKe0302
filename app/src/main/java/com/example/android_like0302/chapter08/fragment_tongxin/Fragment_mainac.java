package com.example.android_like0302.chapter08.fragment_tongxin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.android_like0302.R;

public class Fragment_mainac extends AppCompatActivity {
    //1.准备原始数据
    //1.1图片资源
    int []image={R.drawable.t606_img01,R.drawable.t606_img02,R.drawable.t606_img03,R.drawable.t606_img04,
            R.drawable.t606_img05};
    //1.2电视剧名字资源
    String []name={"小欢喜","长安十二时辰","宸汐缘","大宋少年志","庆余年"};
    //1.3电视剧评分
    String[] rating={"8.4","8.3","8.3","8.2","8.0"};
    //1.4电视剧简介
    String[] introduce={"北京市，三个备战高考的家庭不仅面对着升学压力，更面对着亲子关系难题。恨铁不成钢的妈妈童文洁（海清 饰）和学渣儿子方一凡" +
            "（周奇 饰）之间因为成绩矛盾重重，爸爸方圆（黄磊 饰）不得不左右调停；拒绝前夫乔卫东（沙溢 饰）入侵母女生活的单亲妈妈宋倩（陶虹 饰），" +
            "对女儿乔英子（李庚希 饰）的生活展开了全包围式关切，误解和矛盾不知不觉悄然爆发；空降父亲季胜利（王砚辉 饰）和妈妈刘静（咏梅 饰）的突然" +
            "关怀，让从小养在舅舅刘铮（任重 饰）身边的季杨杨（郭子凡 饰）无所适从，父子之间小心翼翼的相处并没有为这段关系换来和平。 \n" +
            "　　人到中年的家长和刚刚迎来成年的孩子，在高三这场重要的试炼中，度过生活设置的重重难题，在爱与理解中学会成长，迎来属于自己的“小欢喜”",
    "张小敬出身行伍，后受任为主管侦缉逮捕的官差“不良人”，长期协调维护地方安全工作，但却因违法被关押于狱中。负责长安城治安的靖安司发现了混入城内的" +
            "可疑人员，由于张小敬对事发地点人事与地理的熟悉，靖安司特例委派张小敬戴罪立功、侦破此案。经过张小敬的一番调查，发现敌人的阴谋是为了" +
            "在上元节晚上的集会中制造混乱。距离上元节花灯大会只剩下短短的几个时辰了，张小敬必须在上元节花灯大会前抓住搞破坏的刺客。在调查与追捕" +
            "中张小敬还发现靖安司中竟然有敌人的内应，在一次次的斗智斗勇中，张小敬终于在最后关头揭穿了背后主谋，阻止了破坏的发生，解救了长安城里" +
            "的黎民百姓\",",
    "沉睡五万年的战神九宸，被地仙灵汐唤醒，牵出当年神魔大战的众多秘密。九宸因怀疑灵汐身份将其留在身边随侍，两人在相处中渐生情愫。灵汐被发现身怀魔" +
            "气，可以解开魔君封印，两人感情从此命运多舛。九宸不愿枉杀，顶住压力拯救灵汐。灵汐在九宸的帮助下，历尽磨难，终获新生，并发现自己竟是" +
            "山灵族公主。正当两人终将收获爱情之时，山灵界内的幽冥之门开启，魔族入侵，生灵涂炭。危难之时，九宸纵身跳入缚灵渊中以身镇魔……\"",
    "庆历年间，北宋貌似繁华安定的景象下暗潮汹涌，周边各个割据政权的细作潜伏于开封城内，窥探大宋军政秘事。北宋为免除战事，维护各民族间的和平与稳定，" +
            "借秘阁之名，培训少年暗探。经过严密的选拔和审查，诡诈聪慧的元仲辛、美貌机敏的赵简、从不杀生的小景、绝不说谎的王宽、不爱交流的薛映、喜" +
            "欢美女的韦衙内六位少年，因为种种原因，或情愿或被迫，组成了秘阁第七斋。\n" +
            "　　入学之初，少年们心里都有着自己的小算盘，学习的同时也把学斋闹得鸡飞狗跳，让学官们头疼不已。然而在经历了一次次生死相关的任务后" +
            "，曾经年轻懵懂的少年们逐渐成长，他们互相团结，用自己的热血和忠诚，为保卫和平献身。在历史的长河中，他们隐姓埋名，成就无人知晓的暗影传奇",
    "某大学文学史专业的学生张庆熟读古典名著，但他用现代观念剖析古代文学史的论文命题不被叶教授所认可。为了让叶教授成为自己的研究生导师，张庆决定通过写" +
            "小说的方式，进一步阐述自己想要表达的观点。\n" +
            "　　在他的小说中，身世神秘的少年——范闲，自小跟随奶奶生活在海边小城澹州，随着一位老师的突然造访，他看似平静的生活开始直面重重的危机与" +
            "考验。在神秘老师和一位蒙眼守护者的指点下，范闲熟识药性药理，修炼霸道真气并精进武艺，而后接连化解了诸多危局。因对身世之谜的好奇，范闲离" +
            "开澹州，前赴京都。\n" +
            "　　在京都，范闲凭借过人的智谋与勇武成为年轻一代的佼佼者，他先以诗文冠绝京都，而后出使邻国，营救人质，整合谍报网，查处震动朝野的" +
            "走私案……这个过程中，范闲饱尝人间冷暖并坚守对正义、良善的坚持，历经家族、江湖、庙堂的种种考验与锤炼，书写了光彩的人生传奇。"};

    //2.为资源设置getter方法

    public int[] getImage() {
        return image;
    }

    public String[] getName() {
        return name;
    }

    public String[] getRating() {
        return rating;
    }

    public String[] getIntroduce() {
        return introduce;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_mainac);
        init();
    }
    private void init(){
      //3.动态加载两个Fragment
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        Fragment contentFragment=new ContentFragment();
        Fragment listFragment=new NameFragment();

        //加载Fragment
        fragmentTransaction.add(R.id.framcall_list,listFragment,"menu");
        fragmentTransaction.add(R.id.framcall_content,contentFragment,"content");

        fragmentTransaction.commit();
    }
}