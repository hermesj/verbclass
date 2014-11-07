package de.uni_koeln.spinfo.verbclass.verbfeatures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SpecialLexemFinder {

	private Set<String> stoppedAction;
	private Set<String> persuades;
	private Set<String> durations;
	private Set<String> timeUnits;
	private Set<String> intents;
	private Set<String> carefullys;
	private Set<String> almostlys;
	
	private Map<Set<String>, String> allLemmas;
	
	public SpecialLexemFinder(){
		initialize();
	}

	private void initialize() {
		allLemmas = new HashMap<Set<String>, String>();
		
		stoppedAction = new HashSet<String>();
		stoppedAction.addAll(Arrays.asList(new String[] {"aufhören","stoppen"}));
		allLemmas.put(stoppedAction, "stoppedAction");
		
		persuades = new HashSet<String>();
		persuades.addAll(Arrays.asList(new String[] {"überzeugen"}));
		allLemmas.put(persuades, "persuade");
		
				timeUnits = new HashSet<String>();
		timeUnits.addAll(Arrays.asList(new String[] {"sekunde",
				"minute", "stunde", "tag", "woche",
				"monat", "jahr", "jahrzehnt", "jahrhundert", "jahrtausend"}));
		allLemmas.put(timeUnits, "timeUnit");
		
		durations = new HashSet<String>();
		durations.addAll(Arrays.asList(new String[] { "sekundenlang",
				"minutenlang", "stundenlang", "tagelang", "wochenlang",
				"monatelang", "jahrelang", "jahrzehntelang", "jahrhundertelang", "jahrtausendelang"}));
		allLemmas.put(durations, "duration");
		
		intents = new HashSet<String>();
		intents.addAll(Arrays.asList(new String[] {"absichtlich","vorsätzlich"}));
		allLemmas.put(intents, "intent");
		
		carefullys = new HashSet<String>();
		carefullys.addAll(Arrays.asList(new String[] {"sorgfältig"}));
		allLemmas.put(carefullys, "carefully");
		
		almostlys = new HashSet<String>();
		almostlys.addAll(Arrays.asList(new String[] {"fast", "beinahe"}));
		allLemmas.put(almostlys, "almostly");
	}
	
	public String belongsToCategory(String lemma){
		lemma = lemma.toLowerCase();
		if(lemma.equals("mit")){
			return "mit";
		}
		Set<Set<String>> keySet = allLemmas.keySet();
		for (Set<String> set : keySet) {
			if(set.contains(lemma)){
				System.out.println("Found: " + lemma);
				return allLemmas.get(set);
			}
		}
		return null;
	}

}
