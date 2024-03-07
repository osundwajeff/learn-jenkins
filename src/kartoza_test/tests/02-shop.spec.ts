import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('https://kartoza.com/');
  await expect(page.locator('[id="quick\\ bio"]')).toContainText('Unlock insights from your data with the power of GIS');
  await expect(page.getByRole('link', { name: 'Shop' })).toBeVisible();
  await page.getByRole('link', { name: 'Shop' }).click();
  await expect(page.getByRole('main')).toContainText('All Products');
  await expect(page.getByPlaceholder('Search for Products')).toBeEmpty();
  await expect(page.locator('#products-list-area a').filter({ hasText: 'Introduction to QGIS' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'Introduction to QGIS' }).first()).toBeVisible();
  //await expect(page.getByRole('link', { name: 'Explore' })).toBeVisible();
  await expect(page.locator('#products-list-area a').filter({ hasText: 'Introduction to Docker' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'Introduction to Docker' }).first()).toBeVisible();
  await expect(page.locator('#products-list-area a').filter({ hasText: 'GeoNode Hosting and' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'GeoNode Hosting and' }).first()).toBeVisible();
  //await expect(page.getByRole('link', { name: 'Explore' })).toBeVisible();
  await expect(page.locator('#products-list-area a').filter({ hasText: 'GIS Fundamentals for Educators' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'GIS Fundamentals for Educators' }).first()).toBeVisible();
  //await expect(page.getByRole('link', { name: 'Explore' })).toBeVisible();
  await expect(page.locator('#products-list-area a').filter({ hasText: 'Introduction to PostGIS' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'Introduction to PostGIS' }).first()).toBeVisible();
  //await expect(page.getByRole('link', { name: 'Explore' })).toBeVisible();
  await expect(page.locator('#products-list-area a').filter({ hasText: 'Support Package' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'Support Package' }).first()).toBeVisible();
  //await expect(page.getByRole('link', { name: 'Explore' })).toBeVisible();
});