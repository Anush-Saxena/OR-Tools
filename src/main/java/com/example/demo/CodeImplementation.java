package com.example.demo;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import org.springframework.stereotype.Service;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

@Service
public class CodeImplementation {

    public Solution solve(EquationProperties e){
        Loader.loadNativeLibraries();
        MPSolver solver = MPSolver.createSolver("GLOP");
        MPVariable x = solver.makeNumVar(e.getLowerBoundX(), e.getUpperBoundX(), "x");
        MPVariable y = solver.makeNumVar(e.getLowerBoundY(), e.getUpperBoundY(), "y");
        MPConstraint helper = solver.makeConstraint(e.getHelperLowerBound(), e.getHelperUpperBound(), "helper");
        helper.setCoefficient(x, e.getHelperCoeffX());
        helper.setCoefficient(y, e.getHelperCoeffY());

        MPObjective objective = solver.objective();
        objective.setCoefficient(x, e.getCoefficientX());
        objective.setCoefficient(y, e.getCoefficientY());
        if (e.getGoal().equals("Maximize")) {
            objective.setMaximization();
        }
        else{
            objective.setMinimization();
        }
        solver.solve();

        Solution sol = new Solution();
        sol.setAnswer(objective.value());
        sol.setValueX(x.solutionValue());
        sol.setValueY(y.solutionValue());

        return sol;
    }

}
