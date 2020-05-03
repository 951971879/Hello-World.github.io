
public class CustomerDAO
{
	private Connection conn=null;
	private java.sql.PreparedStatement p=null;
	public CustomerDAO()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int login(String mypwd)
	{
		String sql="select * from mysql where pwd = ?";
		try 
		{
			p=conn.prepareStatement(sql);
			p.setString(1, mypwd);
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				return rs.getInt("id");
			}
			rs.close();
			p.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	public Customer query(int id)
	{
		Customer cust=new Customer();
		try
		{
			String sql="select * from mysql where id = ?";
			p=conn.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				cust.setid(rs.getInt("id"));
				cust.setmoney(rs.getInt("money"));
				cust.setname(rs.getString("name"));
				cust.setpwd(rs.getString("pwd"));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return cust;
 
	}
	public void update_get(int id,int money) 
	{
		String sql="select * from mysql where id = ?";
		try 
		{
			p=conn.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				if(rs.getInt("money")<money)
				{
					System.out.println("余额不足！");
				}
				else
				{
					sql="update mysql set money = money - ? where id = ?";
					p=conn.prepareStatement(sql);
					p.setInt(1, money);
					p.setInt(2, id);
					p.executeUpdate();
					System.out.println("取款成功！");
				}
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	public void update_save(int id,int money)
	{
		String sql="update mysql set money = money + ? where id = ?";
		try 
		{
			p=conn.prepareStatement(sql);
			p.setInt(1, money);
			p.setInt(2, id);
			p.executeUpdate();
			System.out.println("存款成功！");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	public void change(int myid,int inid,int money)
	{
		try
		{	String sql="select * from mysql where id = ?";
			p=conn.prepareStatement(sql);
			p.setInt(1, inid);
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				sql="select * from mysql where id = ?";
				p=conn.prepareStatement(sql);
				p.setInt(1, myid);
				rs=p.executeQuery();
				if(rs.next())
				{
					if(rs.getInt("money")<money)
					{
						System.out.println("余额不足！");
						return;
					}
					else
					{
						sql="update mysql set money = money - ? where id = ?";
						p=conn.prepareStatement(sql);
						p.setInt(1, money);
						p.setInt(2, myid);
						p.executeUpdate();
						sql="update mysql set money = money + ? where id = ?";
						p=conn.prepareStatement(sql);
						p.setInt(1, money);
						p.setInt(2, inid);
						p.executeUpdate();
					}
				}
			}
			else
			{
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void Regist(int myid,String mypwd,String myname,int mymoney)
	{
		String sql;
		try
		{
			sql="select * from mysql where id = ?";
			p=conn.prepareStatement(sql);
			p.setInt(1, myid);
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				return;
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		try 
		{
			sql="insert into mysql(id,pwd,money,name) values(?,?,?,?)";
			p=conn.prepareStatement(sql);
			p.setInt(1, myid);
			p.setString(2, mypwd);
			p.setInt(3, mymoney);
			p.setString(4, myname);
			p.executeUpdate();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
}
public SRZ（）
{int a,b,c;
cin>>a>>b>>c;
if(a==b)
{if(b==c)
{cout<<"pass";}

else
cout<<"fail";
}
}
