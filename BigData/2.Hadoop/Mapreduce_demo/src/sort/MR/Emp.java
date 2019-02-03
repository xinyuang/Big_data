package sort.MR;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Emp implements WritableComparable<Emp>{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptno=" + deptno + "]";
	}
	
	@Override
	public void readFields(DataInput input) throws IOException {
		// TODO Auto-generated method stub
		this.empno = input.readInt();
		this.ename = input.readUTF();
		this.job = input.readUTF();
		this.mgr = input.readInt();
		this.hiredate = input.readUTF();
		this.sal = input.readInt();
		this.comm = input.readInt();
		this.deptno = input.readInt();
		
	}
	@Override
	public void write(DataOutput output) throws IOException {
		// TODO Auto-generated method stub
		output.writeInt(this.empno);
		output.writeUTF(this.ename);
		output.writeUTF(this.job);
		output.writeInt(this.mgr);
		output.writeUTF(this.hiredate);
		output.writeInt(this.sal);
		output.writeInt(this.comm);
		output.writeInt(this.deptno);
	}
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int i) {
		this.mgr = i;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		
		if(this.deptno > o.getDeptno()) {
			return 1;
		} else if (this.deptno < o.getDeptno()) {
			return -1;
		}
		
		
		if(this.sal >= o.getSal()) {
			return 1;
		} else {
			return -1;
		}
	}

	
}
