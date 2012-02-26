/*
 * This file is part of Vanilla (http://www.spout.org/).
 *
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.generator.normal.biome;

import net.royawesome.jlibnoise.module.source.Perlin;

import org.spout.api.util.cuboid.CuboidShortBuffer;
import org.spout.vanilla.VanillaMaterials;
import org.spout.vanilla.biome.BiomeType;
import org.spout.vanilla.generator.VanillaBiomeType;
import org.spout.vanilla.generator.normal.decorator.CactusDecorator;
import org.spout.vanilla.generator.normal.decorator.CaveDecorator;
import org.spout.vanilla.generator.normal.decorator.DungeonDecorator;
import org.spout.vanilla.generator.normal.decorator.OreDecorator;

/**
 * Biome consisting of desert-like terrain.
 */
public class DesertBiome extends VanillaBiomeType {
	private Perlin heightMap = new Perlin();

	public DesertBiome() {
		super(2, new CactusDecorator(), new OreDecorator(), new CaveDecorator(), new DungeonDecorator());
		heightMap.setOctaveCount(5);
	}

	@Override
	public void generateColumn(CuboidShortBuffer blockData, int x, int chunkY, int z) {
		int y = chunkY * 16;
		heightMap.setSeed((int) blockData.getWorld().getSeed());

				int height = (int) ((heightMap.GetValue(x / 32.0 + 0.005, 0.05, z / 32.0 + 0.005) + 1.0) * 2.0 + 60.0);

				for (int dy = y; dy < y + 16; dy++) {
					short id = getBlockId(height, dy);
					blockData.set(x, dy, z, id);
		}
	}

	private short getBlockId(int top, int dy) {
		short id;
		if (dy > top) {
			id = VanillaMaterials.AIR.getId();
		} else if (dy + 4 >= top) {
			id = VanillaMaterials.SAND.getId();
		} else if (dy + 5 == top) {
			id = VanillaMaterials.SANDSTONE.getId();
		} else if (dy != 0) {
			id = VanillaMaterials.STONE.getId();
		} else {
			id = VanillaMaterials.BEDROCK.getId();
		}
		return id;
	}
}
