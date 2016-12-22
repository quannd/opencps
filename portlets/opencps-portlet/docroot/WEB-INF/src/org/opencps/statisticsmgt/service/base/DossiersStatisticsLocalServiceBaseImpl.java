/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.statisticsmgt.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.opencps.statisticsmgt.model.DossiersStatistics;
import org.opencps.statisticsmgt.service.DossiersStatisticsLocalService;
import org.opencps.statisticsmgt.service.persistence.DossiersStatisticsFinder;
import org.opencps.statisticsmgt.service.persistence.DossiersStatisticsPersistence;
import org.opencps.statisticsmgt.service.persistence.GovagencyLevelPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the dossiers statistics local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.opencps.statisticsmgt.service.impl.DossiersStatisticsLocalServiceImpl}.
 * </p>
 *
 * @author trungnt
 * @see org.opencps.statisticsmgt.service.impl.DossiersStatisticsLocalServiceImpl
 * @see org.opencps.statisticsmgt.service.DossiersStatisticsLocalServiceUtil
 * @generated
 */
public abstract class DossiersStatisticsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DossiersStatisticsLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.opencps.statisticsmgt.service.DossiersStatisticsLocalServiceUtil} to access the dossiers statistics local service.
	 */

	/**
	 * Adds the dossiers statistics to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossiersStatistics the dossiers statistics
	 * @return the dossiers statistics that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DossiersStatistics addDossiersStatistics(
		DossiersStatistics dossiersStatistics) throws SystemException {
		dossiersStatistics.setNew(true);

		return dossiersStatisticsPersistence.update(dossiersStatistics);
	}

	/**
	 * Creates a new dossiers statistics with the primary key. Does not add the dossiers statistics to the database.
	 *
	 * @param dossierStatisticId the primary key for the new dossiers statistics
	 * @return the new dossiers statistics
	 */
	@Override
	public DossiersStatistics createDossiersStatistics(long dossierStatisticId) {
		return dossiersStatisticsPersistence.create(dossierStatisticId);
	}

	/**
	 * Deletes the dossiers statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossierStatisticId the primary key of the dossiers statistics
	 * @return the dossiers statistics that was removed
	 * @throws PortalException if a dossiers statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DossiersStatistics deleteDossiersStatistics(long dossierStatisticId)
		throws PortalException, SystemException {
		return dossiersStatisticsPersistence.remove(dossierStatisticId);
	}

	/**
	 * Deletes the dossiers statistics from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossiersStatistics the dossiers statistics
	 * @return the dossiers statistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DossiersStatistics deleteDossiersStatistics(
		DossiersStatistics dossiersStatistics) throws SystemException {
		return dossiersStatisticsPersistence.remove(dossiersStatistics);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(DossiersStatistics.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dossiersStatisticsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.statisticsmgt.model.impl.DossiersStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return dossiersStatisticsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.statisticsmgt.model.impl.DossiersStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return dossiersStatisticsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return dossiersStatisticsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return dossiersStatisticsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public DossiersStatistics fetchDossiersStatistics(long dossierStatisticId)
		throws SystemException {
		return dossiersStatisticsPersistence.fetchByPrimaryKey(dossierStatisticId);
	}

	/**
	 * Returns the dossiers statistics with the primary key.
	 *
	 * @param dossierStatisticId the primary key of the dossiers statistics
	 * @return the dossiers statistics
	 * @throws PortalException if a dossiers statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossiersStatistics getDossiersStatistics(long dossierStatisticId)
		throws PortalException, SystemException {
		return dossiersStatisticsPersistence.findByPrimaryKey(dossierStatisticId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return dossiersStatisticsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the dossiers statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.statisticsmgt.model.impl.DossiersStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossiers statisticses
	 * @param end the upper bound of the range of dossiers statisticses (not inclusive)
	 * @return the range of dossiers statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossiersStatistics> getDossiersStatisticses(int start, int end)
		throws SystemException {
		return dossiersStatisticsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dossiers statisticses.
	 *
	 * @return the number of dossiers statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getDossiersStatisticsesCount() throws SystemException {
		return dossiersStatisticsPersistence.countAll();
	}

	/**
	 * Updates the dossiers statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dossiersStatistics the dossiers statistics
	 * @return the dossiers statistics that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DossiersStatistics updateDossiersStatistics(
		DossiersStatistics dossiersStatistics) throws SystemException {
		return dossiersStatisticsPersistence.update(dossiersStatistics);
	}

	/**
	 * Returns the dossiers statistics local service.
	 *
	 * @return the dossiers statistics local service
	 */
	public org.opencps.statisticsmgt.service.DossiersStatisticsLocalService getDossiersStatisticsLocalService() {
		return dossiersStatisticsLocalService;
	}

	/**
	 * Sets the dossiers statistics local service.
	 *
	 * @param dossiersStatisticsLocalService the dossiers statistics local service
	 */
	public void setDossiersStatisticsLocalService(
		org.opencps.statisticsmgt.service.DossiersStatisticsLocalService dossiersStatisticsLocalService) {
		this.dossiersStatisticsLocalService = dossiersStatisticsLocalService;
	}

	/**
	 * Returns the dossiers statistics remote service.
	 *
	 * @return the dossiers statistics remote service
	 */
	public org.opencps.statisticsmgt.service.DossiersStatisticsService getDossiersStatisticsService() {
		return dossiersStatisticsService;
	}

	/**
	 * Sets the dossiers statistics remote service.
	 *
	 * @param dossiersStatisticsService the dossiers statistics remote service
	 */
	public void setDossiersStatisticsService(
		org.opencps.statisticsmgt.service.DossiersStatisticsService dossiersStatisticsService) {
		this.dossiersStatisticsService = dossiersStatisticsService;
	}

	/**
	 * Returns the dossiers statistics persistence.
	 *
	 * @return the dossiers statistics persistence
	 */
	public DossiersStatisticsPersistence getDossiersStatisticsPersistence() {
		return dossiersStatisticsPersistence;
	}

	/**
	 * Sets the dossiers statistics persistence.
	 *
	 * @param dossiersStatisticsPersistence the dossiers statistics persistence
	 */
	public void setDossiersStatisticsPersistence(
		DossiersStatisticsPersistence dossiersStatisticsPersistence) {
		this.dossiersStatisticsPersistence = dossiersStatisticsPersistence;
	}

	/**
	 * Returns the dossiers statistics finder.
	 *
	 * @return the dossiers statistics finder
	 */
	public DossiersStatisticsFinder getDossiersStatisticsFinder() {
		return dossiersStatisticsFinder;
	}

	/**
	 * Sets the dossiers statistics finder.
	 *
	 * @param dossiersStatisticsFinder the dossiers statistics finder
	 */
	public void setDossiersStatisticsFinder(
		DossiersStatisticsFinder dossiersStatisticsFinder) {
		this.dossiersStatisticsFinder = dossiersStatisticsFinder;
	}

	/**
	 * Returns the govagency level local service.
	 *
	 * @return the govagency level local service
	 */
	public org.opencps.statisticsmgt.service.GovagencyLevelLocalService getGovagencyLevelLocalService() {
		return govagencyLevelLocalService;
	}

	/**
	 * Sets the govagency level local service.
	 *
	 * @param govagencyLevelLocalService the govagency level local service
	 */
	public void setGovagencyLevelLocalService(
		org.opencps.statisticsmgt.service.GovagencyLevelLocalService govagencyLevelLocalService) {
		this.govagencyLevelLocalService = govagencyLevelLocalService;
	}

	/**
	 * Returns the govagency level remote service.
	 *
	 * @return the govagency level remote service
	 */
	public org.opencps.statisticsmgt.service.GovagencyLevelService getGovagencyLevelService() {
		return govagencyLevelService;
	}

	/**
	 * Sets the govagency level remote service.
	 *
	 * @param govagencyLevelService the govagency level remote service
	 */
	public void setGovagencyLevelService(
		org.opencps.statisticsmgt.service.GovagencyLevelService govagencyLevelService) {
		this.govagencyLevelService = govagencyLevelService;
	}

	/**
	 * Returns the govagency level persistence.
	 *
	 * @return the govagency level persistence
	 */
	public GovagencyLevelPersistence getGovagencyLevelPersistence() {
		return govagencyLevelPersistence;
	}

	/**
	 * Sets the govagency level persistence.
	 *
	 * @param govagencyLevelPersistence the govagency level persistence
	 */
	public void setGovagencyLevelPersistence(
		GovagencyLevelPersistence govagencyLevelPersistence) {
		this.govagencyLevelPersistence = govagencyLevelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("org.opencps.statisticsmgt.model.DossiersStatistics",
			dossiersStatisticsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.opencps.statisticsmgt.model.DossiersStatistics");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return DossiersStatistics.class;
	}

	protected String getModelClassName() {
		return DossiersStatistics.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dossiersStatisticsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.opencps.statisticsmgt.service.DossiersStatisticsLocalService.class)
	protected org.opencps.statisticsmgt.service.DossiersStatisticsLocalService dossiersStatisticsLocalService;
	@BeanReference(type = org.opencps.statisticsmgt.service.DossiersStatisticsService.class)
	protected org.opencps.statisticsmgt.service.DossiersStatisticsService dossiersStatisticsService;
	@BeanReference(type = DossiersStatisticsPersistence.class)
	protected DossiersStatisticsPersistence dossiersStatisticsPersistence;
	@BeanReference(type = DossiersStatisticsFinder.class)
	protected DossiersStatisticsFinder dossiersStatisticsFinder;
	@BeanReference(type = org.opencps.statisticsmgt.service.GovagencyLevelLocalService.class)
	protected org.opencps.statisticsmgt.service.GovagencyLevelLocalService govagencyLevelLocalService;
	@BeanReference(type = org.opencps.statisticsmgt.service.GovagencyLevelService.class)
	protected org.opencps.statisticsmgt.service.GovagencyLevelService govagencyLevelService;
	@BeanReference(type = GovagencyLevelPersistence.class)
	protected GovagencyLevelPersistence govagencyLevelPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private DossiersStatisticsLocalServiceClpInvoker _clpInvoker = new DossiersStatisticsLocalServiceClpInvoker();
}