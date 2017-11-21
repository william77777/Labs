package week1;

import java.util.HashMap;
import java.util.Map;

import week1.entities.Performer;

public class Audition {

	private Map<Long, Performer> performers;

	public Audition() {
		this.performers = new HashMap<>();
	}
	
	public void addAudition(Performer p) {
		this.performers.put(p.getUnionId(), p);
	}
	
	public void performAuditions(int auditions) {
		if(auditions > this.performers.size())
			throw new IllegalArgumentException("Requested number of auditions exceeds current number of auditions");
		Object [] p = performers.values().toArray();
		for(int i=0; i<auditions; i++)
			System.out.println(((Performer)p[i]).getPerformance());
	}
}
