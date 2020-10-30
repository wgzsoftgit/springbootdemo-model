package com.demomodel.utils.Blockchain.simple;
import java.util.Date;

public class Block {
	
	public String hash;
	public String previousHash; //保存前一个块的hash
	private String data; //数据
	private long timeStamp; //时间
	private int nonce;
	
	//Block Constructor.  
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	//基于块内容计算新哈希
	//Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;
	}
	
	/**
	 * 要求挖矿者做工作量证明
	 * @param difficulty
	 * difficulty难度，低的难度比如1和2，普通的电脑基本都可以马上计算出来，我的建议是在4-6之间进行测试，普通电脑大概会花费3秒时间，在莱特币中难度大概围绕在442592左右，而在比特币中每一次挖矿都要求大概在10分钟左右，当然根据所有网络中的计算能力，难度也会不断的进行修改。
	 */
	//增加nonce值，直到达到哈希目标
	//Increases nonce value until hash target is reached.
	public void mineBlock(int difficulty) {
		String target = StringUtil.getDificultyString(difficulty); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
}