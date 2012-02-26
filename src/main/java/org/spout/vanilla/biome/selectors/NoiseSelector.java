/*
 * This file is part of vanilla (http://www.spout.org/).
 *
 * vanilla is licensed under the SpoutDev License Version 1.
 *
 * vanilla is free software: you can redistribute it and/or modify
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
package org.spout.vanilla.biome.selectors;

import net.royawesome.jlibnoise.module.modifier.Turbulence;
import net.royawesome.jlibnoise.module.source.Voronoi;
import org.spout.vanilla.biome.BiomeSelector;

/**
 * @author zml2008
 */
public class NoiseSelector extends BiomeSelector {
	private Turbulence noise = new Turbulence();
	private Voronoi base = new Voronoi();
	
	public NoiseSelector() {
		base.setFrequency(Math.PI);
		noise.SetSourceModule(0, base);
		noise.setRoughness(4);
		noise.setFrequency(0.8);
		noise.setPower(1.3);
	}
	
	@Override
	public int pickBiome(int x, int y, int z, long seed) {
		base.setSeed((int) seed);
		noise.setSeed((int) seed);
		return (int)(noise.GetValue(x / 256.0 + 0.05, y + 0.05, z / 256.0 + 0.05) * 32);
	}
}
