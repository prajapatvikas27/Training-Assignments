import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class EnemyCount{
	AtomicInteger count =  new AtomicInteger(100);
	AtomicLong totalEnemyForked = new AtomicLong();
	public void incrementCount() {
		count.addAndGet(4);
		totalEnemyForked.addAndGet(4);
	}
	
	public void decrementCount() {
		count.decrementAndGet();
	}
	
	public double getCount(){
		return count.doubleValue();
	}
	
	public long getTotalEnemyCount() {
		return totalEnemyForked.longValue();
	}
}

class AfterDeath implements Runnable{
	EnemyCount enemy = new EnemyCount();
	Lock lock = new ReentrantLock();
	Condition playerDeath = lock.newCondition();
	@Override
	public void run() {
		
		try {
			System.out.println("Started Running");
			playerDeath.await();
			playerDeath.await();
			System.out.println("Total enemies forked:" + enemy.getTotalEnemyCount());
		}catch (InterruptedException e) {
			System.out.println("Got Interrupted");
		}
		finally {
		
		}
		
		
	}

}

class Player implements Runnable{
	
	EnemyCount enemy = new EnemyCount();
	boolean  life = true;
	int playerHit = 0, killCount = 0;
	String playerName;
	AfterDeath afterDeath;
	public Player(String playerName, AfterDeath afterDeath) {
		this.playerName = playerName;
		this.afterDeath = afterDeath;
	}

	@Override
	public void run() {
	
	
		
			while(life) {
				
				Random rand = new Random();
				int n = rand.nextInt(50) + 1;
				
				if(enemy.getCount() == 0) {
					enemy.incrementCount();
				}
		
				if(n % 5 == 0) {
					System.out.println(playerName+" got hit");
					playerHit++;
				}
				else {
					killCount++;
					enemy.decrementCount();
				}
				if(playerHit == 10) {
					life = false;
				}
				
			}
			System.out.println(playerName + " Kill count:" + killCount);
			afterDeath.playerDeath.signalAll();
		
	}	

	
}

public class AtomicVariable {

	public static void main(String[] args) {
		
		AfterDeath afterDeath = new AfterDeath();
		Player first = new Player("Vikas",afterDeath);
		Player second = new Player("Dinu",afterDeath);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(afterDeath);
		service.submit(first);
		service.submit(second);
		
		service.shutdown();
	}

}