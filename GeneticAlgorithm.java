import java.util.function.ToDoubleFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GeneticAlgorithm {
  /***************************************************************
   * Feel free to change the private methods' signatures (I did) *
   * Only the "run" functions are tested                         *
   ***************************************************************/
  private String generate(int length) {
  /*
  Takes an integer length
  Returns a random string of 0's and 1's of the given length
  */
    StringBuilder chromosome = new StringBuilder();
    Random rand = new Random();
    for(int i = 0; i < length; i++) {
      if(rand.nextBoolean() == true) {
        chromosome.append(1);
      }
      else chromosome.append(0);
    }
    return chromosome.toString();
  }
  
  private String[] select(List<String> population, List<Double> fitnesses) {
    /*
    Takes a list of the chromosome population and a corresponding list of fitnesses.
    Returns two weighted random chromosomes from the list, where higher fitnesses give chromosomes more chances to be selected.
    */
    String[] selection = new String[2];
    Random rand = new Random();
    double rand1 = rand.nextDouble();
    double rand2 = rand.nextDouble();
    boolean rand1Done = false;
    boolean rand2Done = false;
    double totalFitness = 0;
    for(int i = 0; i < fitnesses.size(); i++) {
      totalFitness += fitnesses.get(i);
    }
    rand1 *= totalFitness;
    rand2 *= totalFitness;
    int i = 0;
    while(i < fitnesses.size() && (!rand1Done || !rand2Done)) {
      double val = fitnesses.get(i);
      rand1 -= val;
      rand2 -= val;
      if(!rand1Done && rand1 <= 0) {selection[0] = population.get(i); rand1Done = true;}
      if(!rand2Done && rand2 <= 0) {selection[1] = population.get(i); rand2Done = true;}
      i++;
    }
    if(selection[0] == null) {selection[0] = population.get(population.size());}
    if(selection[1] == null) {selection[1] = population.get(population.size());}
    return selection;
  }
  
  private String mutate(String chromosome, double p) {
    /*
    Takes a string of 0's and 1's and a probability p.
    For each 1 or 0 in the string, the value is flipped if a Random number between 0 and 1 is below p.
    Returns the mutated String.
    */
    Random rand = new Random();
    char[] options = {'1','0'};
    char[] chromosomeArray = chromosome.toCharArray();
    for(int i = 0; i < chromosomeArray.length; i++) {
      if(rand.nextDouble() <= p) {
        chromosomeArray[i] = options[Character.getNumericValue(chromosomeArray[i])];
      }
    }
    return String.valueOf(chromosomeArray);
  }
  
  private String[] crossover(String chromosome1, String chromosome2) {
    /*
    Takes two equal length strings.
    Returns two equal length strings, where the first portion of the strings have been swapped after a random number of letters.
    */
    String[] crossovers = new String[2];
    Random rand = new Random();
    int cut = (int)(rand.nextDouble() * chromosome1.length());
    crossovers[0] = chromosome1.substring(0,cut) + chromosome2.substring(cut);
    crossovers[1] = chromosome2.substring(0,cut) + chromosome1.substring(cut);
    return crossovers;
  }
  
  public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
    //Defaults run to 100 iterations.
    return run(fitness, length, p_c, p_m, 100);
  }
  
  public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
    /*
    Runs the genetic algorithm.
    Takes a Function that returns a double and calculates the fitness, along with thelength of the strings, the probabilities of crossover and mutation and the number of iterations to run.
    Generates a random population of size length, using generate().
    Calculates the fitness of the current population with the fitness function.
    Selects chromosomes from the population using select() until a new population of the same size as the orginal is created.
    For each selected pair performs a crossover if a random double between 0 and 1 is less than p_c.
    Potentially modifies each selected chromosome using mutate().
    Returns the desired chromosome (fitness =1), or the highest ranked chromosome after the given number of iterations.
    */
    int popSize = 200;
    double maxFitness = 0;
    int maxFitnessPos = 0;
    Random rand = new Random();
    ArrayList<String> oldPop = new ArrayList<String>();
    ArrayList<String> newPop = new ArrayList<String>();
    ArrayList<Double> fitnesses = new ArrayList<Double>();
    String[] selection = new String[2];
    for(int i = 0; i < popSize; i++) {
      oldPop.add(generate(length));
      fitnesses.add(fitness.applyAsDouble(oldPop.get(i)));
    }
    for(int i = 1; i <= iterations; i++) {
      for(int j = 0; j < popSize/2; j++) {
        selection = select(oldPop, fitnesses);
        if(rand.nextDouble() < p_c) {selection = crossover(selection[0],selection[1]);}
        selection[0] = mutate(selection[0], p_m);
        selection[1] = mutate(selection[1], p_m);
        newPop.add(selection[0]);
        newPop.add(selection[1]);
      }
      oldPop.clear();
      fitnesses.clear();
      for(int j = 0; j < newPop.size(); j++) {
        oldPop.add(newPop.get(j));
        if(fitness.applyAsDouble(oldPop.get(j)) > maxFitness) {
          maxFitness = fitness.applyAsDouble(oldPop.get(j));
          maxFitnessPos = j;
        }
        fitnesses.add(fitness.applyAsDouble(oldPop.get(j)));
      }
      if(maxFitness == 1) {return oldPop.get(maxFitnessPos);}
      newPop.clear();
    }
    return oldPop.get(maxFitnessPos);
  }
}