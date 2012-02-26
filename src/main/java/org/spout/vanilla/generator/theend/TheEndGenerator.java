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
package org.spout.vanilla.generator.theend;

import org.spout.vanilla.biome.BiomeGenerator;
import org.spout.vanilla.biome.selectors.NoiseSelector;
import org.spout.vanilla.biome.selectors.SingleSelector;
import org.spout.vanilla.generator.theend.biome.EndStoneBiome;

/**
 * Generator that generates The End-like worlds.
 */
public class TheEndGenerator extends BiomeGenerator {
	/**
	 * Called during biome generator's construction phase
	 */
	@Override
	public void registerBiomes() {
		setSelector(new SingleSelector(0));
		register(new EndStoneBiome());
		//TODO: Create The End's biome(s);
	}
}
