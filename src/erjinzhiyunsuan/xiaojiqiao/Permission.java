package erjinzhiyunsuan.xiaojiqiao;

/**
 * 演示二进制鉴权
 * <p>
 * 在没有系统学习二进制鉴权以前：
 * 我使用二进制判断权限是将一个数字通过 Integer.toBinaryString()  转换为二进制字符串
 * 然后根据约定好的第一位为 查询位，第二位为 插入位，第三位为 更新位，第四位 为删除位。
 * 通过String.charAt(x)去判断  x位在字符串上 是否位1 来判断用户是否有权限。
 * ！！！！！！ 这样做有很多不好的地方！！！！！！
 * 如 ：
 * 一：
 * 最开始：
 * 如果权限位到了10000  而传入的数字位4（代表查询权限），通过Integer.toBinaryString() 获取到的二进制字符串为100
 * 于是前面的0被省略， 去charAt（10000）时会抛出异常，此时需要准确捕获异常，这样造成了判断没有权限的依据
 * 是抛出空指针异常，与charAt(x)为1，这样 写代码非常的不方便，会造成冗余代码，与判断无权限的位置不统一。
 * 二：
 * 后来：
 * 企业电量中实际使用的是SQL实现的，通过
 * 权限数字 & 权限
 * 查看是否等于 权限 来判断是否是 拥有此权限。
 * 如一个用户他的权限数字是26 他的2进制是11010  4（代表查询权限）他的 二进制为100
 * 11010 & 100   等于0
 * 显然 权限数字为26的这个用户没有 查询权限
 * 最后总结：
 * 其实后来改进的方案也很好，在sql 中实现 主要是为了展示列表，不是用来判断是否有权限，
 * 所以 使用CASE WHEN e.Enum_Enterprise_SpecialType_ID & 4=4 then '降负荷不达标企业,'  else '''' end
 * 这种方式去展示列表是正确的，sql一下全查出来了。
 * 同样道理 在判断权限时，拿到用户的权限数字，去& 权限  查看是否等于权限 则可判断 是否存在此权限。
 * <p>
 * 再说一点：
 * 关于权限设置，建议在数据库中以key value 形式  存储起来，如
 * name（权限名）    value（权限值）
 * 查询              1
 * 增加              10
 * 删除              100
 * 更改              1000
 * 这样 前端通过数据库中 约定的权限 传给后台
 * 由后台去直接 (增加/更改) 或 (判断)权限
 * <p>
 * 初次增加权限：
 * 0x0F ｜ 权限值 来增加权限
 * 追加权限：
 * 用户权限数字 ｜ 权限值
 * 删除权限:
 * 用户权限数字 &～ 权限值
 * 判断权限
 * 用户权限数字  &  权限值   = 权限值
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/17 上午7:29
 * @Version 1.0
 */
public class Permission {
    /**
     * 代表查询权限  1往左移0位
     */
    public static final int ALLOW_SELECT = 1 << 0;//0001
    /**
     * 代表插入权限  1往左移1位
     */
    public static final int ALLOW_INSERT = 1 << 1;//0010
    /**
     * 代表更新权限  1往左移2位
     */
    public static final int ALLOW_UPDATE = 1 << 2;//0100
    /**
     * 代表删除权限  1往左移3位
     */
    public static final int ALLOW_DELETE = 1 << 3;//1000


    private int flag;

    public void setPer(int per) {
        flag = per;
    }

    /**
     * 追加权限
     * 就是给位设1 比照 位上有1 就给他设置1 没有 依然为0
     *
     * @param per
     */
    public void enable(int per) {
        flag = flag | per;
    }

    /**
     * 删除权限
     * 就是给位设置0 将权限值取反，然后通过 & 运算符
     * 保留上下都是 1的位 ，删除上为1 下为0的位
     *
     * @param per
     */
    public void disable(int per) {
        flag = flag & ~per;
    }

    /**
     * 判断用户是否拥有per权限
     *
     * @param per
     * @return
     */
    public boolean isAllow(int per) {
        return (flag & per) == per;
    }

    /**
     * 判断用户是否没有per权限
     *
     * @param per
     * @return
     */
    public boolean isNotAllow(int per) {
        return (flag & per) == 0;
    }


    public static void main(String[] args) {
        //15表示用户所以权限都有
        int flag = 15;
        //鉴权器
        Permission permission = new Permission();
        permission.setPer(flag);
        //禁止用户的查询与插入权限 ，使用｜ 会将两个权限结合起来  传入disable方法
        permission.disable(ALLOW_SELECT | ALLOW_INSERT);
        System.out.println(permission.isAllow(ALLOW_SELECT));
        System.out.println(permission.isAllow(ALLOW_DELETE));

        System.out.println(permission.isNotAllow(ALLOW_INSERT));
    }

}
