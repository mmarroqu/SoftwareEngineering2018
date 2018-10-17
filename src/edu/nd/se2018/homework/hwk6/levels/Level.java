package edu.nd.se2018.homework.hwk6.levels;


import java.util.List;

import edu.nd.se2018.homework.hwk6.Player;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import edu.nd.se2018.homework.hwk6.levels.Key;

public interface Level {
	public void buildWalls(ObservableList<Node> root, int[][] levelGrid, Player player, List<Key> keys, List<Gate> gates, List<Monster> monsters);
}
