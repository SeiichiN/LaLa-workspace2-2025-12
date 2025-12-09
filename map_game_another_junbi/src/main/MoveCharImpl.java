package main;

import util.Utility;

public class MoveCharImpl implements MoveChar {
	GameManager gm;
	// 移動方向
	// {0, 0} は移動しない
	// {y, x} は y, x 方向に移動
	private final int[][] DIR = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	// 移動済みのモンスターのマップ
	// １回ごとにこのマップは '.' で初期化される。
	// モンスターが移動したら、その場所に 'g' または 's' を入れる。
	// これは、移動済みのモンスターが再度移動しないようにするためである。
	private final char[][] moveMap;
	
	public MoveCharImpl(GameManager gm) {
		this.gm = gm;
		this.moveMap = new char[gm.YSIZE][gm.XSIZE];
		initMoveMap();
	}
	
	private void initMoveMap() {
		for (int y = 0; y < gm.YSIZE; y++) {
			for (int x = 0; x < gm.XSIZE; x++) {
				this.moveMap[y][x] = '.';
			}
		}
	}
	
	private boolean isHereMonster(int y, int x) {
		if (gm.map[y][x] == 'g' || gm.map[y][x] == 's') {
			// 移動済みのモンスターがいなければ、true
			if (this.moveMap[y][x] == '.') return true;
		}
		return false;
	}
	
	@Override
	public void move() {
		initMoveMap();
		for (int y = 0; y < gm.YSIZE; y++) {
			for (int x = 0; x < gm.XSIZE; x++) {
				if (isHereMonster(y, x)) {
					moveCharacter(y, x);
				}
			}
		}
	}
	
	private boolean isMovable(int y, int x) {
		if (y < 0 || y >= gm.YSIZE || x < 0 || x >= gm.XSIZE) return false;
		if (gm.map[y][x] != '.') return false;
		return true;
	}
	
	private void moveCharacter(int y, int x) {
		char ch = gm.map[y][x];
		gm.map[y][x] = '.';
		int nextY, nextX;
		while (true) {
			int idx = Utility.RND.nextInt(5);
			nextY = y + DIR[idx][0];
			nextX = x + DIR[idx][1];
			if (isMovable(nextY, nextX)) break;
		}
		gm.map[nextY][nextX] = ch;
		this.moveMap[nextY][nextX] = ch;
	}
	
}
